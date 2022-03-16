package com.training.redditclone.repositories;

import com.training.redditclone.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
