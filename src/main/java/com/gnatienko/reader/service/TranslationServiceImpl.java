package com.gnatienko.reader.service;

import com.gnatienko.reader.model.Word;
import com.gnatienko.reader.repository.InternalDictionary;
import com.gnatienko.reader.repository.LearnedWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TranslationServiceImpl {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private LearnedWordsService learnedWordsService;


    public List<String> removeSpecialCharacters(List<String> words) {
        List<String> list = new ArrayList<>();
        if(words == null){ return new ArrayList<>();}
        for (String word : words) {
            String wordWithoutPunctuation = StringUtils.replace(word, "[^a-zA-Z0-9]'’", "");
            list.add(wordWithoutPunctuation);
        }

        return list;
    }



    private List<String> translate(List<String> wordsWithoutPunctuations) {
        List<String> translationList = new ArrayList<>();
        for (String word : wordsWithoutPunctuations) {
            if ((!StringUtils.isEmpty(word)) & !(learnedWordsService.isLearned(word))) { //
                String russianTranslation = dictionaryService.getRussianTranslation( word.toLowerCase());
                translationList.add(russianTranslation);
            } else {
                translationList.add("");
            }
        }
        return translationList;
    }

    private List<String> splitByWhitespaces(String text) {
        if (text != null) {
            return Arrays.asList(text.split(" "));
        }
        return new ArrayList<>();
    }

    public List<Word> getTranslationPairs(String text) {

        List<String> initialWords = splitByWhitespaces(text); // "word," "word2" "word" "."
        List<String> wordsWithoutPunctuations = removeSpecialCharacters(initialWords); // "word" 'word2' "word" ""

        List<String> translation = translate(wordsWithoutPunctuations);
        List<Word> wordsList = new ArrayList<>();
        for(int i=0;i<initialWords.size();i++){

            wordsList.add(new Word(initialWords.get(i),translation.get(i),Long.valueOf(i)));
        }
        return wordsList;    }
}