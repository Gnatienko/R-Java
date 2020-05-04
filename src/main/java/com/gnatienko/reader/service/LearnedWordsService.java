package com.gnatienko.reader.service;


import com.gnatienko.reader.model.LearnedWordsEntity;
import com.gnatienko.reader.repository.LearnedWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LearnedWordsService {
    @Autowired
    private LearnedWordsRepository repository;

    public LearnedWordsEntity save(LearnedWordsEntity entity) {
        return repository.save(entity);
    }

    public LearnedWordsEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));
    }
    public List<LearnedWordsEntity> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
