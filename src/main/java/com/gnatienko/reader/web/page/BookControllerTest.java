/*
package com.gnatienko.reader.web.page;

import com.gnatienko.reader.model.BookContentEntity;
import com.gnatienko.reader.service.BookContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
//@RestController
//@RequestMapping("/22")
public class BookControllerTest {

    @Autowired
    private BookContentService service1;

    @GetMapping  ("/11")//("/{book_id}/{page_number}")
    public String findBook(Model model) {
        List<BookContentEntity> books = service1.findByBookIdAndPageNumber(1L, 1L); //1 лонг
        model.addAttribute( "books1", books); //books1 - ключ, books - содержание по ключу
        return "page_book_content"; //название страницы.хтмл


    }

}
*/
