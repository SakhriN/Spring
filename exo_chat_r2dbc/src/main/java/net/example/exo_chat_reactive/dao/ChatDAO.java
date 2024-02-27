package net.example.exo_chat_reactive.dao;

import net.example.exo_chat_reactive.model.ChatMessage;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.*;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class ChatDAO {

    private final ConnectionFactory connectionFactory;

    private DatabaseClient databaseClient;

    public ChatDAO(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        Mono result = databaseClient
                .sql("CREATE TABLE IF NOT EXISTS chat_message(id int primary key auto_increment, sender varchar(2000), content varchar(2000), timestamp datetime);")
                .then().doOnSuccess((Void) -> {
                    System.out.println("Création de la table OK");
                }).doOnError((Void) -> {
                    System.out.println("Création de la table Not OK");
                });
        result.subscribe();
    }

    public Flux<ChatMessage> getAll() {
        return databaseClient.sql("SELECT * from chat_message").fetch()
                .all()
                .map(c -> ChatMessage.builder()
                        .id(Integer.valueOf(c.get("id").toString()))
                        .sender(c.get("sender").toString())
                        .content(c.get("content").toString())
                        .build());
    }
    public Mono<ChatMessage> getOne(int id) {
        return databaseClient.sql("SELECT * FROM chat_message WHERE id = :id")
                .bind("id", id)
                .fetch()
                .one()
                .map(m -> ChatMessage.builder()
                        .id(Integer.valueOf(m.get("id").toString()))
                        .sender(m.get("sender").toString())
                        .content(m.get("content").toString())
                        .timestamp(LocalDateTime.parse(m.get("timestamp").toString()))
                        .build());
    }

    public Mono<ChatMessage> add(ChatMessage chatMessage) {
        Map<String, Object> values = new HashMap<>();
        values.put("sender", chatMessage.getSender());
        values.put("content", chatMessage.getContent());
        values.put("timestamp", LocalDateTime.now()     );
        Mono result = databaseClient.sql("INSERT INTO chat_message (sender, content, timestamp) values (:sender, :content, :timestamp)")
                //.bind("firstname", firstname).bind("lastname", lastname)
                .bindValues(values)
                .then();
        return result;
    }

    public Mono delete(int id) {
        return databaseClient.sql("DELETE FROM chat_message where id=:id").bind("id", id).then();
    }

    public Mono<Long> update(int id, String sender, String content) {
        Map<String, Object> values = new HashMap<>();
        values.put("sender", sender);
        values.put("content", content);
        values.put("timestamp", LocalDateTime.now());
        values.put("id", id);
        return databaseClient
                .sql("UPDATE chat_message set sender = :sender, content =:content, timestamp = :timestamp where id = :id")
                .bindValues(values).fetch().rowsUpdated();
    }
}
