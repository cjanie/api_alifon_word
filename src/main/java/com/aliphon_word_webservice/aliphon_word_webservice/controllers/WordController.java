package com.aliphon_word_webservice.aliphon_word_webservice.controllers;

import java.util.List;

import com.aliphon_word_webservice.aliphon_word_webservice.entities.Word;
import com.aliphon_word_webservice.aliphon_word_webservice.exceptions.DatabaseException;
import com.aliphon_word_webservice.aliphon_word_webservice.services.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="rest/words")
@CrossOrigin(origins="*")
public class WordController {
    
    @Autowired
    private WordService wordService;

    @GetMapping
    public ResponseEntity<?> get() {
        try {
            List<Word> words = this.wordService.get();
            return new ResponseEntity<List<Word>>(words, HttpStatus.OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Word word) {
        try {
            this.wordService.add(word);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (DatabaseException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
