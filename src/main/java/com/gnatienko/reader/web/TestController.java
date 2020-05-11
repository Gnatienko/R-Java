package com.gnatienko.reader.web;


import com.gnatienko.reader.model.BookContentEntity;
import com.gnatienko.reader.model.Word;
import com.gnatienko.reader.service.BookContentService;
import com.gnatienko.reader.service.BookNamesService;
import com.gnatienko.reader.service.TranslationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")//localhost:3000~*
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TranslationServiceImpl translationService;
    @Autowired
    private BookNamesService bookNamesService;
    @Autowired
    private BookContentService bookContentService;

    @GetMapping
    public   ResponseEntity<List<Word>> getContentEntity(){  //ResponseEntity<BookContentEntity> getContentEntity() {
/*
        BookContentEntity bookContentEntity = new BookContentEntity();
        bookContentEntity.setBookId(1L);
        bookContentEntity.setId(1L);
        bookContentEntity.setContent("Test");
        bookContentEntity.setPageN(1L);
*/

        List<Word> word = translationService.getTranslationPairs( bookContentService.findByBookIdAndPageNumber(1L, 1L).getContent());

        return ResponseEntity.ok(word);
    }

    @PostMapping
    public ResponseEntity<BookContentEntity> postContentEntity( @RequestBody BookContentEntity bookContentEntity){
        System.out.println(bookContentEntity.getContent().toString());
        return ResponseEntity.ok(bookContentEntity);
    }



}
