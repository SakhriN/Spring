package net.example.exo_aspect.controller;

import net.example.exo_aspect.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/create")
    public ResponseEntity<String> get() {
        /*System.out.println("---------- Boolean ---------");
        //demoService.methodReturnBoolean();
        System.out.println("---------- Method void avec exception ---------");
        demoService.method();*/

        bookService.createBook("Test 1er", "Nassim Sakhri");

        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        /*System.out.println("---------- Boolean ---------");
        //demoService.methodReturnBoolean();
        System.out.println("---------- Method void avec exception ---------");
        demoService.method();*/

        bookService.deleteBook(id);

        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<String> getone(@PathVariable("id")int id) {
        /*System.out.println("---------- Boolean ---------");
        //demoService.methodReturnBoolean();
        System.out.println("---------- Method void avec exception ---------");
        demoService.method();*/

        bookService.getBook(id);

        return ResponseEntity.ok("Ok");
    }
}
