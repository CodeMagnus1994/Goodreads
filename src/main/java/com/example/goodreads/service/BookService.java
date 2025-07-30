package com.example.goodreads.service;

import com.example.goodreads.entity.BookEntity;
import com.example.goodreads.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public BookEntity getBook(int id) {
        return bookRepository.findById(id).get();
    }

    public BookEntity updateBook(BookEntity bookEntity, int id) {

        BookEntity book = bookRepository.findById(id).get();

        if(bookEntity.getTitle() != null) {
            book.setTitle(bookEntity.getTitle());
        }
        if(bookEntity.getAuthor() != null) {
            book.setAuthor(bookEntity.getAuthor());
        }
        if(bookEntity.getBookEnum() != null) {
            book.setBookEnum(bookEntity.getBookEnum());
        }

        return bookRepository.save(book);
    }

    public void deleteBook(int id) {

        bookRepository.deleteById(id);

    }

}
