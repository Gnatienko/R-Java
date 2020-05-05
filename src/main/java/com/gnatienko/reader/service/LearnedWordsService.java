package com.gnatienko.reader.service;


import com.gnatienko.reader.model.LearnedWordEntity;
import com.gnatienko.reader.repository.InternalDictionary;
import com.gnatienko.reader.repository.LearnedWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class LearnedWordsService {
    @Autowired
    private LearnedWordsRepository repository;
    @Autowired
    private InternalDictionary internalDictionary;
    @Autowired
    private UserService userService;


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

    public Boolean isLearned(String word){
        if (internalDictionary.findByEnglish(word).isPresent()){
            return repository.findByUserIdAndWordId(userService.userId(), (internalDictionary.findByEnglish(word).get().getId())).isPresent();
        } else {
            return false;
        }

    }


}
