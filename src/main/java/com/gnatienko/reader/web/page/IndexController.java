/*
 * Copyright (c) 2020 Javatar LLC
 * All rights reserved.
 */
package com.gnatienko.reader.web.page;

import com.gnatienko.reader.model.UserEntity;
import com.gnatienko.reader.model.Word;
import com.gnatienko.reader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Svitlana Onyshchenko / Javatar LLC
 * @version 26-04-2020
 */
@Controller
public class IndexController {

    @Autowired
    private UserService service;

    //Autowire service here to use it

    @GetMapping("/hello")
    public String pageWelcome(Model model) {
        model.addAttribute("message", "111");
        return "page_welcome";
    }

    @GetMapping("/") // Вызывается при запросе локалхост
    public String index(Model model) {
        //call service here to show data in UI

        List<Word> page = new LinkedList<>();
        page.add(new Word("I", "Я", 1L));
        page.add(new Word("am", "есть", 2L));
        page.add(new Word("the", "", 3L));
        page.add(new Word("LAW", "закон", 4L));

        List<UserEntity> users = this.service.findAll();
        model.addAttribute("users", users);
        model.addAttribute("page", page);
        return "index";
    }
}
