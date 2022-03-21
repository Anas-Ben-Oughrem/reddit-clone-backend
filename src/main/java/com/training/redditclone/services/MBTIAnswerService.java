package com.training.redditclone.services;

import com.training.redditclone.entities.MBTIAnswer;
import com.training.redditclone.entities.NormalAnswer;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.repositories.MBTIAnswerRepository;
import com.training.redditclone.repositories.NormalAnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MBTIAnswerService {

    private final MBTIAnswerRepository mbtiAnswerRepository;

    public MBTIAnswer createQuestion(MBTIAnswer mbtiAnswer){
        return mbtiAnswerRepository.save(mbtiAnswer);
    }

    public MBTIAnswer updateQuestion(MBTIAnswer mbtiAnswer){
        return  mbtiAnswerRepository.save(mbtiAnswer);
    }

    public MBTIAnswer getMBTIAnswer(Long id) {
        return mbtiAnswerRepository.findById(id)
                .orElseThrow(()->new SpringRedditException("No question was found with given id"));
    }

    public void deleteQuestion(Long id){
        mbtiAnswerRepository.deleteById(id);
    }
}
