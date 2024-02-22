package net.example.exo_aspect.service;

import net.example.exo_aspect.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    List<Book> books = new ArrayList<>();
int foutagedegueule = 1;
    public void createBook(String title, String author) {
        // Logique de création du livre
        Random random = new Random();
        Book book = new Book(/*random.nextInt(99999) + 1*/ foutagedegueule++, title, author);
        books.add(book);
        System.out.println(books);
    }

    public void deleteBook(int bookId) {
        Book book = getBook(bookId);
        List<Book> boobs = books;
        boobs.remove(book);
        books = boobs;
        System.out.println(books);
    }

    public Book getBook(int bookId) {
        Book book = books.stream().filter(bo -> bo.getBookId() == (bookId)).findFirst().orElse(null);
        if (book==null){
            System.out.println("nique ta mere, y a zero livre");
        }
        System.out.println(book);
        return book;
    }
}
