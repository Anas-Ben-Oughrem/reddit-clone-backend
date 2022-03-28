package com.training.redditclone.services;

import com.training.redditclone.entities.MBTIQuiz;
import com.training.redditclone.entities.NormalQuiz;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.repositories.MBTIQuizRepository;
import com.training.redditclone.repositories.NormalQuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MBTIQuizService {

    private final MBTIQuizRepository mbtiQuizRepository;

    public MBTIQuiz createQuiz(MBTIQuiz quiz){
        return mbtiQuizRepository.save(quiz);
    }

    public MBTIQuiz updateQuiz(MBTIQuiz normalQuiz){
        return mbtiQuizRepository.save(normalQuiz);
    }

    public MBTIQuiz getQuizById(Long id) {
        return mbtiQuizRepository.findById(id)
                .orElseThrow(()-> new SpringRedditException("No quiz was found with the given id"));
    }

    public MBTIQuiz getQuizByTitle(String title){
        return  mbtiQuizRepository.findMBTIQuizByTitle(title)
                .orElseThrow(()-> new SpringRedditException("No quiz was found with the given title"));
    }

    public void deleteQuiz(Long id){
        mbtiQuizRepository.deleteById(id);
    }
}
