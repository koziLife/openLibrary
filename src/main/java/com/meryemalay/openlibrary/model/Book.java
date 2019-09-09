package com.meryemalay.openlibrary.model;

import java.util.Date;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private Date publishedDate;
    private int numberOfPage;
    private BookFormat format;
    private String edition;
    private String description;
    private String editionLanguage;

    public Book(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author =author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public BookFormat getFormat() {
        return format;
    }

    public void setFormat(BookFormat format) {
        this.format = format;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditionLanguage() {
        return editionLanguage;
    }

    public void setEditionLanguage(String editionLanguage) {
        this.editionLanguage = editionLanguage;
    }
}
