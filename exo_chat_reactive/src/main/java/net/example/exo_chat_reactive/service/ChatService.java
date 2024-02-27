package net.example.exo_chat_reactive.service;

import net.example.exo_chat_reactive.model.ChatMessage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class ChatService {

    private final Sinks.Many<ChatMessage> chatMessageSink;

    public ChatService() {this.chatMessageSink = Sinks.many().multicast().onBackpressureBuffer();}

    public void postMessage(ChatMessage message) {chatMessageSink.tryEmitNext(message);}

    public Flux<ChatMessage> getChatMessages() {return chatMessageSink.asFlux();}

}
