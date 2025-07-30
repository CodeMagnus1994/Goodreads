package com.example.goodreads.service;

import com.example.goodreads.entity.CollectionEntity;
import com.example.goodreads.entity.PatronEntity;
import com.example.goodreads.repository.BookRepository;
import com.example.goodreads.repository.CollectionRepository;
import com.example.goodreads.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatronService {

    private PatronRepository patronRepository;

    @Autowired
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public PatronEntity createPatron(PatronEntity patronEntity) {
        return patronRepository.save(patronEntity);
    }

    public PatronEntity getPatron(int id) {
        return patronRepository.findById(id).get();
    }

    public PatronEntity updatePatron(PatronEntity patronEntity, int id) {

        PatronEntity patron = patronRepository.findById(id).get();

        if(patronEntity.getUsername() != null) {
            patron.setUsername(patronEntity.getUsername());
        }
        if(patronEntity.getPassword() != null) {
            patron.setPassword(patronEntity.getPassword());
        }

        return patronRepository.save(patron);
    }

    public void deletePatron(int id) {

        PatronEntity patron = patronRepository.findById(id).get();

        patronRepository.deleteById(id);
    }

}
