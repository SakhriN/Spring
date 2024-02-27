package net.example.exo_chat_reactive.repository;

import net.example.exo_chat_reactive.model.ChatMessage;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends R2dbcRepository<ChatMessage, Integer> {


}
