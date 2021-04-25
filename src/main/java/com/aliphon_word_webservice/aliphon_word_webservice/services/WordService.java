package com.aliphon_word_webservice.aliphon_word_webservice.services;

import java.util.ArrayList;
import java.util.List;

import com.aliphon_word_webservice.aliphon_word_webservice.entities.Word;
import com.aliphon_word_webservice.aliphon_word_webservice.exceptions.DatabaseException;
import com.aliphon_word_webservice.aliphon_word_webservice.repositories.WordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    
    @Autowired
    private WordRepository wordRepository;

    public List<Word> get() throws DatabaseException {
        List<Word> words = new ArrayList<>();
        this.wordRepository.findAll().forEach(word -> {
            words.add(word);
        });
        return words;
    }
}
