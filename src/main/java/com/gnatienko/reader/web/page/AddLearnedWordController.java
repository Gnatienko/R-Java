/*
package com.gnatienko.reader.web.page;

import com.gnatienko.reader.model.LearnedWordEntity;
import com.gnatienko.reader.model.Word;
import com.gnatienko.reader.service.LearnedWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/add_learned_word")
public class AddLearnedWordController {
    @Autowired
    private LearnedWordsService learnedWordsService;


    @GetMapping("/{learned_word}")
    public String findBook(Model model, @PathVariable(name = "learned_word") String learnedWord ) {
        model.addAttribute( "learnedWord", learnedWordsService.save(learnedWord)); // атрибуты которые передаются в хтмл
        return "add_learned_word_page" ;
    }
}
*/
