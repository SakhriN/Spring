package net.example.exo_chat_reactive.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import net.example.exo_chat_reactive.model.ChatMessage;
import net.example.exo_chat_reactive.service.ChatService;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
@RequestMapping("/api/chat")
public class ChatReactiveController {

    private final ChatService chatService;

    @Autowired
    public ChatReactiveController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/message")
    public ChatMessage postMessage(@RequestBody ChatMessage message) {
        chatService.postMessage(message);
        return message;
    }

    @GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatMessage> subscribe() {
        return chatService.getChatMessages();
    }
}
