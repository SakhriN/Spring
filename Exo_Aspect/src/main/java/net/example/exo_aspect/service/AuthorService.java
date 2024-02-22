package net.example.exo_aspect.service;

import net.example.exo_aspect.entity.Author;
import net.example.exo_aspect.entity.Book;
import net.example.exo_aspect.log.CustomAnnotation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    List<Author> authors = new ArrayList<>();
    int foutagedegueule = 1;

    @CustomAnnotation
    public Author createAuthor(String firstname, String lastname) {
        // Logique de création du livre
        Random random = new Random();
        Author author = new Author(foutagedegueule++, firstname, lastname, new ArrayList<>());
        authors.add(author);
        return author;
    }

    public void deleteAuthor(int authorId) {
        Author author = getAuthor(authorId);
        List<Author> authorbs = authors;
        authorbs.remove(author);
        authors = authorbs;
    }

    @CustomAnnotation
    public Author getAuthor(int authorId) {
        Author author = authors.stream().filter(au -> au.getAuthorId() == (authorId)).findFirst().orElse(null);
        if (author == null) {
            System.out.println("nique ta mere, y a zero livre");
        }
        return author;
    }

    @CustomAnnotation
    public List<Author> getAllAuthors() {
        return authors;
    }
}
