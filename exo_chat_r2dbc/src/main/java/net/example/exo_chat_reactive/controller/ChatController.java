package net.example.exo_chat_reactive.controller;


import net.example.exo_chat_reactive.dao.ChatDAO;
import net.example.exo_chat_reactive.model.ChatMessage;
import net.example.exo_chat_reactive.repository.ChatRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("chat")
public class ChatController {

//    private final ChatDAO chatRepository;
//
//    public ChatController(ChatDAO chatRepository) {
//        this.chatRepository = chatRepository;
//    }
//
//    @GetMapping
//    public Flux<ChatMessage> getAll() {
//        return chatRepository.getAll();
//    }
//
//    @GetMapping("{id}")
//    public Mono<ChatMessage> get(@PathVariable("id") int id) {
//        return chatRepository.getOne(id);
//    }
//    @PostMapping
//    public Mono<ChatMessage> post(@RequestBody ChatMessage chatMessage) {
//        return chatRepository.add(chatMessage);
//    }

    private final ChatRepository chatRepository;

    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @GetMapping
    public Flux<ChatMessage> getAll() {
        return chatRepository.findAll();
    }

    @GetMapping("{id}")
    public Mono<ChatMessage> get(@PathVariable("id") int id) {
        return chatRepository.findById(id);
    }
    @PostMapping
    public Mono<ChatMessage> post(@RequestBody ChatMessage chatMessage) {
        return chatRepository.save(chatMessage);
    }
}






