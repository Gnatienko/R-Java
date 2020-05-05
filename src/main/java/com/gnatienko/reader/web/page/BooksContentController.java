package com.gnatienko.reader.web.page;

import com.gnatienko.reader.model.BookNamesEntity;
import com.gnatienko.reader.model.Word;
import com.gnatienko.reader.service.BookContentService;
import com.gnatienko.reader.service.BookNamesService;
import com.gnatienko.reader.service.TranslationServiceImpl;
import com.gnatienko.reader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksContentController {
    Long userId = 1L ;

    @Autowired
    private BookNamesService bookNamesService;
    @Autowired
    private BookContentService bookContentService;
    @Autowired
    private TranslationServiceImpl translationService;
    @Autowired
    private UserService userService;


    @GetMapping("")
    public String allUserBooks (Model model) {
        String userName = userService.get(userId).getName();
        List<BookNamesEntity> userBookNames = bookNamesService.findByUserId(userId);
        model.addAttribute( "userBookNames", userBookNames); //передача атрибутов на фронт
        model.addAttribute( "userName", userName);
        return "books_names_page";



   }


     @GetMapping ("/{book_id}/{page_number}")
    public String findBook(Model model, @PathVariable(name = "book_id") Long bookId, @PathVariable(name = "page_number") Long pageNumber ) {

        List<Word> word = translationService.getTranslationPairs( bookContentService.findByBookIdAndPageNumber(bookId, pageNumber).get(0).getContent()); //1 лонг
        model.addAttribute( "words", word); //books1 - ключ, books - содержание по ключу
        return "books_content_page" ;//"index_test"; //название страницы.хтмл
    }

}

