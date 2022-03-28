package com.training.redditclone.repositories;

import com.training.redditclone.entities.Collaborators;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorsRepository extends JpaRepository <Collaborators,Integer>{
}
