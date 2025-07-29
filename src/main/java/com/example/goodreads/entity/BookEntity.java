package com.example.goodreads.entity;

import com.example.goodreads.enumerations.BookEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="genre")
    private BookEnum bookEnum;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "books"
    )
    @JsonIgnoreProperties
    private List<CollectionEntity> collection;

    public BookEntity() {}

    public BookEntity(String title, String author, BookEnum bookEnum) {
        this.title = title;
        this.author = author;
        this.bookEnum = bookEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<CollectionEntity> getCollection() {
        return collection;
    }

    public void setCollection(List<CollectionEntity> collection) {
        this.collection = collection;
    }

    public BookEnum getBookEnum() {
        return bookEnum;
    }

    public void setBookEnum(BookEnum bookEnum) {
        this.bookEnum = bookEnum;
    }
}
