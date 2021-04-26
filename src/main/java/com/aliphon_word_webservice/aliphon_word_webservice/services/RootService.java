package com.aliphon_word_webservice.aliphon_word_webservice.services;

import java.util.ArrayList;
import java.util.List;

import com.aliphon_word_webservice.aliphon_word_webservice.entities.Root;
import com.aliphon_word_webservice.aliphon_word_webservice.exceptions.DatabaseException;
import com.aliphon_word_webservice.aliphon_word_webservice.repositories.RootRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootService {

    @Autowired
    private RootRepository rootRepository;

    public List<Root> get() throws DatabaseException {
        List<Root> roots = new ArrayList<>();
        rootRepository.findAll().forEach(root -> {
            roots.add(root);
        });
        return roots;
    }
    
}
