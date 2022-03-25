package com.training.redditclone.controllers;


import com.training.redditclone.entities.NormalQuestion;

import com.training.redditclone.services.NormalQuestionService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class NormalQuestionController {

    private final NormalQuestionService normalQuestionService;

    @PostMapping
    public NormalQuestion createNormalQuestion(@RequestBody NormalQuestion normalQuestion){
        return normalQuestionService.createQuestion(normalQuestion);
    }

    @PutMapping
    public NormalQuestion updateNormalQuestion(@RequestBody NormalQuestion normalQuestion){
        return normalQuestionService.updateQuestion(normalQuestion);
    }

    @GetMapping
    public List<NormalQuestion> getAllNormalQuestionzes(){
        return normalQuestionService.getAllNormalQuestions();
    }

    @GetMapping("/{id}")
    public NormalQuestion getNormalQuestion(@PathVariable Long id){
        return  normalQuestionService.getNormalQuestion(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id){
        normalQuestionService.deleteQuestion(id);
    }
}
