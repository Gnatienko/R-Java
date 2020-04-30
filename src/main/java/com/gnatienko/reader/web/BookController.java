package com.gnatienko.reader.web;

import com.gnatienko.reader.model.BookContentEntity;
import com.gnatienko.reader.service.BookContentService;
import com.gnatienko.reader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/books")
public class BookController {

    @Autowired
    private BookContentService service;

    @GetMapping  ("/1/1")//("/{book_id}/{page_number}")
    public String findBook(Model model) {
        List<BookContentEntity> books = service.findByBookIdAndPageNumber(1L, 1L); //1 лонг
        model.addAttribute( "books1", books); //books1 - ключ, books - содержание по ключу
        return "page_book_content"; //название страницы.хтмл
    }
}
