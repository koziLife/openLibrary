package com.meryemalay.openlibrary.controller;

import com.meryemalay.openlibrary.model.Book;
import com.meryemalay.openlibrary.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/book/")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/book/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return bookService.getBookByIsbn(isbn);
    }

    @PostMapping("/book/")
    public ResponseEntity<Void> addBook(@RequestBody Book newBook, UriComponentsBuilder builder){
        Book book = bookService.addBook(newBook);

        if(book == null){
            return ResponseEntity.noContent().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/book/{isbn}").buildAndExpand(book.getIsbn()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}
