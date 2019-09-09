package com.meryemalay.openlibrary.service;

import com.meryemalay.openlibrary.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getBooks();

    public Book getBookByIsbn(String isbn);

    public Book addBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(String isbn);
}
