package com.training.redditclone.repositories;

import com.training.redditclone.entities.Event;
import com.training.redditclone.entities.LikeEvent;
import com.training.redditclone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  LikeEventRepo extends JpaRepository<LikeEvent,Integer> {
	List<LikeEvent> findByEvent(Event event);
	List<LikeEvent> findByUser(User user);
}
