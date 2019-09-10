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
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/book/")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBookById(@PathVariable int id){
        return bookService.getBookById(id);
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

    @PutMapping("/book/")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Optional<Book> updateBook = bookService.getBookById(book.getId());

        if(updateBook == null){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

//        updateBook.get().setIsbn(book.getIsbn());
//        updateBook.get().setTitle(book.getTitle());
//        updateBook.get().setAuthor(book.getAuthor());
//        updateBook.get().setDescription(book.getDescription());
//        updateBook.get().setEditionLanguage(book.getEditionLanguage());
//        updateBook.get().setEdition(book.getEdition());
//        updateBook.get().setFormat(book.getFormat());
//        updateBook.get().setNumberOfPage(book.getNumberOfPage());
//        updateBook.get().setPublishedDate(book.getPublishedDate());
//        updateBook.get().setPublisher(book.getPublisher());

        bookService.updateBook(book);

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id){
        Optional<Book> book = bookService.getBookById(id);

        if(book == null){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

        bookService.deleteBook(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }


}
