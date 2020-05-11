package com.gnatienko.reader.web.page;

import com.gnatienko.reader.service.LearnedWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delete_learned_word")
public class DeleteLearnedWordController {
    @Autowired
    private LearnedWordsService learnedWordsService;


    @GetMapping("/{learned_word}")
    public String findBook(Model model, @PathVariable(name = "learned_word") String learnedWord ) {
        model.addAttribute( "learnedWord", learnedWordsService.delete(learnedWord)); // атрибуты которые передаются в хтмл
        return "add_learned_word_page" ;
    }
}
