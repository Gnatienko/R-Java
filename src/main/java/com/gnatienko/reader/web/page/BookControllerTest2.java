package com.gnatienko.reader.web.page;

import com.gnatienko.reader.model.BookContentEntity;
import com.gnatienko.reader.model.Word;
import com.gnatienko.reader.service.BookContentService;
import com.gnatienko.reader.service.TranslationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RestController
//@RequestMapping("/22")
public class BookControllerTest2 {

    @Autowired
    private BookContentService bookContentService;
    @Autowired
    private TranslationServiceImpl translationService;


    @GetMapping  ("/12")//("/{book_id}/{page_number}")
    public String findBook(Model model) {
        List<Word> word = translationService.getTranslationPairs( bookContentService.findByBookIdAndPageNumber(1L, 1L).get(0).getContent()); //1 лонг
        model.addAttribute( "words", word); //books1 - ключ, books - содержание по ключу
        return "index_test"; //название страницы.хтмл

    }

}
