package com.training.redditclone.repositories;

import com.training.redditclone.entities.MBTIAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MBTIAnswerRepository extends JpaRepository<MBTIAnswer,Long> {

    List<MBTIAnswer> findAllByMbtiQuestion_Id(Long id);
}
