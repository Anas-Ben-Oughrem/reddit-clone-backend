package com.training.redditclone.repositories;

import com.training.redditclone.entities.MBTIQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MBTIQuestionRepository extends JpaRepository<MBTIQuestion,Long> {
}
