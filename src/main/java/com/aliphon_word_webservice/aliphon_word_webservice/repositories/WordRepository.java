package com.aliphon_word_webservice.aliphon_word_webservice.repositories;

import com.aliphon_word_webservice.aliphon_word_webservice.entities.Word;

import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long>{
}
