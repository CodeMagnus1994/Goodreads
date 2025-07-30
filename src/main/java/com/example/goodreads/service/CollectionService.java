package com.example.goodreads.service;

import com.example.goodreads.entity.BookEntity;
import com.example.goodreads.entity.CollectionEntity;
import com.example.goodreads.repository.BookRepository;
import com.example.goodreads.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {

    private CollectionRepository collectionRepository;
    private BookRepository bookRepository;

    @Autowired
    public CollectionService(CollectionRepository collectionRepository, BookRepository bookRepository) {
        this.collectionRepository = collectionRepository;
        this.bookRepository = bookRepository;
    }

    public CollectionEntity createCollection(CollectionEntity collectionEntity) {
        return collectionRepository.save(collectionEntity);
    }

    public CollectionEntity getCollection(int id) {
        return collectionRepository.findById(id).get();
    }

    public CollectionEntity updateCollection(CollectionEntity collectionEntity, int id) {

        CollectionEntity collection = collectionRepository.findById(id).get();

        List<BookEntity> entireCollection = new ArrayList<>();

        entireCollection.addAll(collection.getBooks());

        for(BookEntity book : collectionEntity.getBooks()) {

            BookEntity associatedBook = bookRepository.findById(book.getId())
                            .orElseThrow(() -> new RuntimeException("Book Not found"));

            associatedBook.setTitle(associatedBook.getTitle());
            associatedBook.setAuthor(associatedBook.getAuthor());
            associatedBook.setBookEnum(associatedBook.getBookEnum());

            entireCollection.add(associatedBook);
        }

        collection.setBooks(entireCollection);

        return collectionRepository.save(collection);
    }

    public void deleteCollection(int id) {
        collectionRepository.deleteById(id);
    }

}
