package com.meryemalay.openlibrary.service;

import com.meryemalay.openlibrary.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> getBooks();

    public Optional<Book> getBookById(int id);

    public Book addBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(int id);
}
