package net.example.exo_chat_reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ChatMessage {
    @Id
    private int id;
    private String sender;
    private String content;
    private LocalDateTime timestamp;

    public ChatMessage() {
        this.timestamp = LocalDateTime.now();
    }

    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

}
