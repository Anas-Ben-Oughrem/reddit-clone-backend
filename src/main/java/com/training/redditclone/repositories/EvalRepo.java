package com.training.redditclone.repositories;

import com.training.redditclone.entities.Eval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EvalRepo extends JpaRepository<Eval,Integer> {

}
