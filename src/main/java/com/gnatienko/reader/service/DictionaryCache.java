package com.gnatienko.reader.service;

import com.gnatienko.reader.model.InternalDictionaryEntity;
import com.gnatienko.reader.repository.InternalDictionary;
import com.gnatienko.reader.repository.LearnedWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DictionaryCache {

    @Autowired
    private InternalDictionary repository;
    @Autowired
    private LearnedWordsRepository learnedWordsRepository;


    @Cacheable("P")
    public Map<String, String > getMap() {
        Map<String, String > hashMap = new HashMap<String, String >();

        List<InternalDictionaryEntity> all = repository.findAll();
        for (InternalDictionaryEntity internalDictionaryEntity : all) {
            hashMap.put(internalDictionaryEntity.getEnglish(), internalDictionaryEntity.getRussian()); //???
        }
        return hashMap;
    }




}
