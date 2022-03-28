package com.training.redditclone.services;

import com.training.redditclone.entities.NormalQuiz;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.repositories.NormalQuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NormalQuizService {

    private final NormalQuizRepository normalQuizRepository;

    public NormalQuiz createQuiz(NormalQuiz normalQuiz){
        return normalQuizRepository.save(normalQuiz);
    }

    public NormalQuiz updateQuiz(NormalQuiz normalQuiz){
        return normalQuizRepository.save(normalQuiz);
    }

    public NormalQuiz getQuizById(Long id) {
        return normalQuizRepository.findById(id)
                .orElseThrow(()-> new SpringRedditException("No quiz was found with the given id"));
    }

    public NormalQuiz getQuizByTitle(String title){
        return  normalQuizRepository.findNormalQuizByTitle(title)
                .orElseThrow(()-> new SpringRedditException("No quiz was found with the given title"));
    }

    public List<NormalQuiz> getAllNormalQuizzes(){
        return normalQuizRepository.findAll();
    }

    public void deleteQuiz(Long id){
        normalQuizRepository.deleteById(id);
    }
}
