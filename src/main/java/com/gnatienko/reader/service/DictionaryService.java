package com.gnatienko.reader.service;

import com.gnatienko.reader.model.InternalDictionaryEntity;
import com.gnatienko.reader.model.UserEntity;
import com.gnatienko.reader.repository.InternalDictionary;
import com.gnatienko.reader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DictionaryService {
    @Autowired //депенденси инжекшн анотация
    private InternalDictionary repository;

    public InternalDictionaryEntity save(InternalDictionaryEntity entity) {
        return repository.save(entity);
    }

    public List<InternalDictionaryEntity> findAll() {
        return repository.findAll();
    }

    public String getRussianTranslation(String english) {
        Optional<InternalDictionaryEntity> byEnglish = repository.findByEnglish(english);
        if (byEnglish.isPresent()) {
            return byEnglish.get().getRussian();
        } else {
            return "#";
        }
    }
}
