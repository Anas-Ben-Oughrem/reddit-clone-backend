package com.training.redditclone.repositories;

import com.training.redditclone.entities.CommentEvent;
import com.training.redditclone.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentEventRepository extends JpaRepository<CommentEvent, Integer> {

	//@Query("select c from CommentEvent c where c.idEvent=: idEvnt")
	List<CommentEvent> findByEvent(Event event);
	
	
	
}
