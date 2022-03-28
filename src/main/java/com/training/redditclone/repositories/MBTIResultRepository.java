package com.training.redditclone.repositories;

import com.training.redditclone.entities.MBTIResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MBTIResultRepository extends JpaRepository<MBTIResult,Long> {

    Optional<MBTIResult> findByUser_Username(String username);
}
