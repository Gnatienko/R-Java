package com.gnatienko.reader.service;


import com.gnatienko.reader.model.InternalDictionaryEntity;
import com.gnatienko.reader.model.LearnedWordEntity;
import com.gnatienko.reader.repository.InternalDictionary;
import com.gnatienko.reader.repository.LearnedWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class LearnedWordsService {
    @Autowired
    private LearnedWordsRepository repository;
    @Autowired
    private InternalDictionary internalDictionary;
    @Autowired
    private UserService userService;
    @Autowired
    DictionaryService dictionaryService;



/*    public String save(String learnedWord) {


        Long id = internalDictionary.findByEnglish(learnedWord).get().getId();
        if (!isLearned(learnedWord)){
            LearnedWordEntity learnedWordEntity = new LearnedWordEntity();
            dictionaryService.getRussianTranslation(learnedWord); //добавляем слово в словарь, так как его может не быть
            learnedWordEntity.setUserId(userService.userId());
            learnedWordEntity.setWordId(id);
            repository.save(learnedWordEntity);
            return "Word "+learnedWord+" is added";

        }else {
            return "Word is learned already";
        }



    }*/

    public LearnedWordEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));
    }
    public List<LearnedWordEntity> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public Boolean isLearned(String word){
        Optional<InternalDictionaryEntity> byEnglish = internalDictionary.findByEnglish(word);
        if (byEnglish.isPresent()){
            return repository.findByUserIdAndWordId(userService.userId(), (byEnglish.get().getId())).isPresent();
        } else {
            return false;
        }

    }


}
