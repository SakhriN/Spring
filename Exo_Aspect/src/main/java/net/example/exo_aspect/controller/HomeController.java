package net.example.exo_aspect.controller;

import net.example.exo_aspect.entity.Author;
import net.example.exo_aspect.entity.Book;
import net.example.exo_aspect.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/create")
    public ResponseEntity<Book> get() {
        /*System.out.println("---------- Boolean ---------");
        //demoService.methodReturnBoolean();
        System.out.println("---------- Method void avec exception ---------");
        demoService.method();*/

        Book book = bookService.createBook("Test 1er", new Author(bookService.));

        return ResponseEntity.ok(book);
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
    public ResponseEntity<Book> getone(@PathVariable("id")int id) {
        /*System.out.println("---------- Boolean ---------");
        //demoService.methodReturnBoolean();
        System.out.println("---------- Method void avec exception ---------");
        demoService.method();*/
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Book>> getall(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
