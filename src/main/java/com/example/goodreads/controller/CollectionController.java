package com.example.goodreads.controller;

import com.example.goodreads.entity.CollectionEntity;
import com.example.goodreads.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CollectionController {

    private CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @PostMapping("collection")
    public CollectionEntity createCollection(@RequestBody CollectionEntity collection) {
        return collectionService.createCollection(collection);
    }

    @GetMapping("collection/{id}")
    public CollectionEntity getCollection(@PathVariable int id) {
        return collectionService.getCollection(id);
    }

    @PutMapping("collection/{id}")
    public CollectionEntity updateCollection(@RequestBody CollectionEntity collection, @PathVariable  int id) {
        return collectionService.updateCollection(collection, id);
    }

    @DeleteMapping("collection/{id}")
    public String deleteCollection(@PathVariable int id) {

        collectionService.deleteCollection(id);
        return "Collection " + id + " has been deleted!";
    }

}
