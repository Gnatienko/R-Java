package com.gnatienko.reader.service;

import com.gnatienko.reader.model.InternalDictionaryEntity;
import com.gnatienko.reader.model.LearnedWordEntity;
import com.gnatienko.reader.repository.InternalDictionary;
import com.gnatienko.reader.repository.LearnedWordsRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class DictionaryService {
    Long userId = 1L ;

    private static final Logger log = LoggerFactory.getLogger(DictionaryService.class);

    @Autowired
    private InternalDictionary repository;
    @Autowired
    private DictionaryCache dictionaryCache;
    @Autowired
    private LearnedWordsRepository learnedWordsRepository;


    private RestTemplate restTemplate = new RestTemplate();

    private String removeSpecialCharacters(String word) {
        return word == null ? StringUtils.EMPTY : word.replaceAll( "[^a-zA-Z'’]", "");
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
        Optional<LearnedWordEntity> learned = learnedWordsRepository.findByUserIdAndWordId(userId, repository.findByEnglish(english).get().getId());

        if (!learned.isPresent()) {
            if (byEnglish.isPresent()) { // to do. add extra condition
                return dictionaryCache.getMap().get(english);//byEnglish.get().getRussian();

            } else {
                try {
                    String apiURL = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=ru&dt=t&q=";
                    ResponseEntity<Object[]> response = restTemplate.getForEntity(apiURL + english, Object[].class);
                    ArrayList arr = (ArrayList) ((ArrayList) response.getBody()[0]).get(0);
                    String russian = (String) arr.get(0);
                    var entity = new InternalDictionaryEntity(english, russian);
                    repository.save(entity);
                    return "+" + russian;
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    return "#";
                }

            }
        } else {
            return "_";
        }


    }
}
