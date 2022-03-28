package com.training.redditclone.repositories;

import com.training.redditclone.entities.NormalAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NormalAnswerRepository extends JpaRepository<NormalAnswer,Long> {
}
