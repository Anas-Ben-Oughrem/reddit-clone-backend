package com.training.redditclone.repositories;

import com.training.redditclone.entities.MBTIQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MBTIQuizRepository extends JpaRepository<MBTIQuiz,Long> {

    Optional<MBTIQuiz> findMBTIQuizByTitle(String title);
}
