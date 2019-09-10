package com.meryemalay.openlibrary.service;

import com.meryemalay.openlibrary.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class BookServiceImpl  implements BookService{

    private static List<Book> books = new ArrayList<>();

    static {
        Book book1 = new Book(1,"473ASD","Java", "Meryem");
        Book book2 = new Book(2, "7436R", "C#", "Savas");
        Book book3 = new Book(3, "8847SD", "Spring", "Meryem");

        books.add(book1);
        books.add(book2);
        books.add(book3);
    }
    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    @Override
    public Book addBook(Book book) {
        Random random = new Random();
        int nextId = random.nextInt() +10;

        book.setId(nextId);
        books.add(book);
        return book;
    }

    @Override
    public void updateBook(Book newBook) {
        books
                .stream()
                .filter(b -> b.getId() == newBook.getId())
                .map(book -> {
                    book.setIsbn(newBook.getIsbn());
                    book.setAuthor(newBook.getAuthor());
                    book.setTitle(newBook.getTitle());
                    book.setDescription(newBook.getDescription());
                    book.setEditionLanguage(newBook.getEditionLanguage());
                    book.setEdition(newBook.getEdition());
                    book.setFormat(newBook.getFormat());
                    book.setNumberOfPage(newBook.getNumberOfPage());
                    book.setPublishedDate(newBook.getPublishedDate());
                    book.setPublisher(newBook.getPublisher());
                    return book;
                });
    }

    @Override
    public void deleteBook(int id) {
        books
                .stream()
                .filter(book -> book.getId() == id)
                .map(book -> books.remove(book));
    }
}
