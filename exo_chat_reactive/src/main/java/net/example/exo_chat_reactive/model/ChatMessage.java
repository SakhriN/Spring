package net.example.exo_chat_reactive.model;

import lombok.*;
import java.time.LocalDateTime;

@Data
public class ChatMessage {
    private int id;
    private String sender;
    private String content;
    private LocalDateTime timestamp;

    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

}
