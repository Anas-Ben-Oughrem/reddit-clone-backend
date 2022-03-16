package com.training.redditclone.repositories;

import com.training.redditclone.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
