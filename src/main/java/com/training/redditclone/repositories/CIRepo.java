package com.training.redditclone.repositories;

import com.training.redditclone.entities.CI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIRepo extends JpaRepository<CI, Integer> {
}
