package com.training.redditclone.repositories;

import com.training.redditclone.entities.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  BadgeRepo extends JpaRepository<Badge,Integer> {

}
