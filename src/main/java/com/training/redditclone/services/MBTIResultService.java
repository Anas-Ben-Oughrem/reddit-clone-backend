package com.training.redditclone.services;

import com.training.redditclone.entities.MBTIResult;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.repositories.MBTIResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MBTIResultService {

    private final MBTIResultRepository mbtiResultRepository;

    public MBTIResult createQuestion(MBTIResult mbtiResult){
        return mbtiResultRepository.save(mbtiResult);
    }

    public MBTIResult updateQuestion(MBTIResult mbtiResult){
        return  mbtiResultRepository.save(mbtiResult);
    }

    public MBTIResult getMBTIResult(Long id) {
        return mbtiResultRepository.findById(id)
                .orElseThrow(()->new SpringRedditException("No question was found with given id"));
    }

    public void deleteQuestion(Long id){
        mbtiResultRepository.deleteById(id);
    }


}
