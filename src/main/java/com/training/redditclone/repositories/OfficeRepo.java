package com.training.redditclone.repositories;


import com.training.redditclone.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OfficeRepo extends JpaRepository<Office,Integer> {

}
