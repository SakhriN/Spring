package net.example.exo_aspect.service;

import net.example.exo_aspect.entity.Author;
import net.example.exo_aspect.entity.Book;
import net.example.exo_aspect.log.CustomAnnotation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    List<Book> books = new ArrayList<>();
    int foutagedegueule = 1;

    @CustomAnnotation
    public Book createBook(String title, Author author) {
        // Logique de création du livre
        Random random = new Random();

        Book book = new Book(/*random.nextInt(99999) + 1*/ foutagedegueule++, title, author);
        books.add(book);
        return book;
    }

    public void deleteBook(int bookId) {
        Book book = getBook(bookId);
        List<Book> boobks = books;
        boobks.remove(book);
        books = boobks;
    }
    @CustomAnnotation
    public Book getBook(int bookId) {
        Book book = books.stream().filter(bo -> bo.getBookId() == (bookId)).findFirst().orElse(null);
        if (book == null) {
            System.out.println("nique ta mere, y a zero livre");
        }
        return book;
    }

    @CustomAnnotation
    public List<Book> getAllBooks() {
        return books;
    }
}
