package com.aliphon_word_webservice.aliphon_word_webservice.controllers;

import java.util.List;

import com.aliphon_word_webservice.aliphon_word_webservice.entities.Root;
import com.aliphon_word_webservice.aliphon_word_webservice.exceptions.DatabaseException;
import com.aliphon_word_webservice.aliphon_word_webservice.services.RootService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/roots")
@CrossOrigin(origins = "*")
public class RootController {

    @Autowired
    RootService rootService;
    
    @GetMapping
    public ResponseEntity<?> get() {
        try {
            List<Root> roots = this.rootService.get();
            return new ResponseEntity<List<Root>>(roots, HttpStatus.OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
