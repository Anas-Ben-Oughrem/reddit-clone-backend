package com.training.redditclone.services;

import com.training.redditclone.entities.NormalQuestion;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.repositories.NormalQuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NormalQuestionService {

    private final NormalQuestionRepository normalQuestionRepository;

    public NormalQuestion createQuestion(NormalQuestion normalQuestion){
        return normalQuestionRepository.save(normalQuestion);
    }

    public NormalQuestion updateQuestion(NormalQuestion normalQuestion){
        return  normalQuestionRepository.save(normalQuestion);
    }

    public NormalQuestion getNormalQuestion(Long id) {
        return normalQuestionRepository.findById(id)
                .orElseThrow(()->new SpringRedditException("No question was found with given id"));
    }

    public void deleteQuestion(Long id){
        normalQuestionRepository.deleteById(id);
    }

    public List<NormalQuestion> getAllNormalQuestions() {
        return normalQuestionRepository.findAll();
    }
}
