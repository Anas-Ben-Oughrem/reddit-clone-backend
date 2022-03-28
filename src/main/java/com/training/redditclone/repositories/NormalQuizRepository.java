package com.training.redditclone.repositories;

import com.training.redditclone.entities.NormalQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NormalQuizRepository extends JpaRepository<NormalQuiz,Long> {

    Optional<NormalQuiz> findNormalQuizByTitle(String title);
}
