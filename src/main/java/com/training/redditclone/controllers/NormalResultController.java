package com.training.redditclone.controllers;

import com.training.redditclone.entities.NormalAnswer;
import com.training.redditclone.entities.Result;
import com.training.redditclone.services.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/normal-results")
@AllArgsConstructor
public class NormalResultController {

    private final ResultService resultService;

    @PostMapping
    public Result createResult(@RequestBody Result result){
        return resultService.createResult(result);
    }

    @PutMapping
    public Result updateResult(@RequestBody Result result){
        return resultService.updateResult(result);
    }

    @GetMapping("/{id}")
    public Result getResult(@PathVariable Long id){
        return resultService.getResult(id);
    }

    @PostMapping("/{id}/{passingScore}")
    public void setPassingScore(@PathVariable Long id , @PathVariable int passingScore){
        resultService.setPassingScore(id,passingScore);
    }

    @PostMapping("/{id}")
    public void setResult(@PathVariable Long id, @RequestBody List<NormalAnswer> answers){
        resultService.setResult(id,answers);
    }
}
