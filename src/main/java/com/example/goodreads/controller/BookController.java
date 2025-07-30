package com.example.goodreads.controller;

import com.example.goodreads.entity.BookEntity;
import com.example.goodreads.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("book")
    public BookEntity createBook(@RequestBody BookEntity bookEntity) {
        return bookService.createBook(bookEntity);
    }

    @GetMapping("book/{id}")
    public BookEntity getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @PutMapping("book/{id}")
    public BookEntity updateBook(@RequestBody BookEntity bookEntity, @PathVariable int id) {
        return bookService.updateBook(bookEntity,id);
    }

    @DeleteMapping("book/{id}")
    public String deleteBook(@PathVariable int id) {

        bookService.deleteBook(id);
        return "Book " + id + " has been deleted!";
    }
}
