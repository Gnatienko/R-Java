package com.gnatienko.reader.service;


import com.gnatienko.reader.model.LearnedWordEntity;
import com.gnatienko.reader.repository.LearnedWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PublicKey;
import java.util.List;

public class LearnedWordsService {
    @Autowired
    private LearnedWordsRepository repository;

    public LearnedWordEntity save(LearnedWordEntity entity) {
        return repository.save(entity);
    }

    public LearnedWordEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));
    }
    public List<LearnedWordEntity> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }


}
