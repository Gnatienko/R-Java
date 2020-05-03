package com.gnatienko.reader.service;

import com.gnatienko.reader.model.InternalDictionaryEntity;
import com.gnatienko.reader.repository.InternalDictionary;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DictionaryService {

    private static final Logger log = LoggerFactory.getLogger(DictionaryService.class);

    @Autowired //депенденси инжекшн анотация
    private InternalDictionary repository;

    private RestTemplate restTemplate = new RestTemplate();

    private String removeSpecialCharacters(String word) {
        return word == null ? StringUtils.EMPTY : word.replaceAll( "[^a-zA-Z0-9]", "");
    }

    public InternalDictionaryEntity save(InternalDictionaryEntity entity) {
        return repository.save(entity);
    }

    public List<InternalDictionaryEntity> findAll() {
        return repository.findAll();
    }

    public String getRussianTranslation(String english) {
        english = removeSpecialCharacters(english);
        Optional<InternalDictionaryEntity> byEnglish = repository.findByEnglish(english);
        if (byEnglish.isPresent()) {
            return byEnglish.get().getRussian();
        } else {
            try {
                String apiURL = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=ru&dt=t&q=";
                ResponseEntity<Object[]> response = restTemplate.getForEntity(apiURL + english, Object[].class);
                ArrayList arr = (ArrayList)((ArrayList) response.getBody()[0]).get(0);
                String russian = (String) arr.get(0);
                var entity = new InternalDictionaryEntity(english, russian);
                repository.save(entity);
                return russian;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return "#";
            }
        }
    }
}
