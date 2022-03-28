package com.training.redditclone.repositories;

import com.training.redditclone.entities.NormalQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NormalQuestionRepository extends JpaRepository<NormalQuestion,Long> {
}
