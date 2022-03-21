package com.training.redditclone.services;

import com.training.redditclone.entities.NormalAnswer;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.repositories.NormalAnswerRepository;
import com.training.redditclone.repositories.NormalAnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NormalAnswerService {

    private final NormalAnswerRepository normalAnswerRepository;

    public NormalAnswer createQuestion(NormalAnswer normalAnswer){
        return normalAnswerRepository.save(normalAnswer);
    }

    public NormalAnswer updateQuestion(NormalAnswer normalAnswer){
        return  normalAnswerRepository.save(normalAnswer);
    }

    public NormalAnswer getNormalAnswer(Long id) {
        return normalAnswerRepository.findById(id)
                .orElseThrow(()->new SpringRedditException("No question was found with given id"));
    }

    public void deleteQuestion(Long id){
        normalAnswerRepository.deleteById(id);
    }
}
