package com.meryemalay.openlibrary.service;

import com.meryemalay.openlibrary.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BookServiceImpl  implements BookService{

    private static List<Book> books = new ArrayList<>();

    static {
        Book book1 = new Book("1", "Java", "Meryem");
        Book book2 = new Book("2", "C#", "Savas");
        Book book3 = new Book("3", "Spring", "Meryem");

        books.add(book1);
        books.add(book2);
        books.add(book3);
    }
    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        for(Book book: books){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }

    @Override
    public Book addBook(Book book) {
        Random random = new Random();
        int nextId = random.nextInt() +10;

        book.setIsbn(nextId+"isbn");
        books.add(book);
        return book;
    }

    @Override
    public void updateBook(Book book) {
        for(Book oldBook: books){
            if(oldBook.getIsbn() == book.getIsbn()){
                oldBook.setAuthor(book.getAuthor());
                oldBook.setTitle(book.getTitle());
            }
        }

    }

    @Override
    public void deleteBook(String isbn) {
        for(Book book: books){
            if(book.getIsbn() == isbn){
                books.remove(book);
            }
        }
    }
}
