package com.example.goodreads.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name="collection")
public class CollectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // Submissive side.
    @OneToOne(
            mappedBy = "collection",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JsonBackReference
    private PatronEntity patron;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name="collection_book",
            joinColumns = @JoinColumn(name="collection"),
            inverseJoinColumns = @JoinColumn(name="book")
    )
    @JsonIgnoreProperties
    private List<BookEntity> books;

    public CollectionEntity(PatronEntity patron, List<BookEntity> books) {
        this.patron = patron;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public PatronEntity getPatron() {
        return patron;
    }

    public void setPatron(PatronEntity patron) {
        this.patron = patron;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
