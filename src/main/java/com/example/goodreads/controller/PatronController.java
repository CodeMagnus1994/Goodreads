package com.example.goodreads.controller;

import com.example.goodreads.entity.PatronEntity;
import com.example.goodreads.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PatronController {

    private PatronService patronService;

    @Autowired
    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @PostMapping("patron")
    public PatronEntity createPatron(@RequestBody PatronEntity patronEntity) {
        return patronService.createPatron(patronEntity);
    }

    @GetMapping("patron/{id}")
    public PatronEntity getPatron(@PathVariable int id) {
        return patronService.getPatron(id);
    }

    @PutMapping("patron/{id}")
    public PatronEntity updatePatron(@RequestBody PatronEntity patronEntity, @PathVariable int id) {

        return patronService.updatePatron(patronEntity, id);
    }

    @DeleteMapping("patron/{id}")
    public String deletePatron(@PathVariable int id) {
        patronService.deletePatron(id);
        return "patron " + id + " has been deleted!";
    }

}
