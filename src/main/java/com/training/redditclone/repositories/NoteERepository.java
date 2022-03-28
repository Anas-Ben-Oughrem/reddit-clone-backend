package com.training.redditclone.repositories;


import com.training.redditclone.entities.Event;
import com.training.redditclone.entities.NoteE;
import com.training.redditclone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteERepository extends JpaRepository<NoteE, Integer> {
	List<NoteE> findByEvent(Event event);
	List<NoteE> findByUser(User user);
	List<NoteE> findByUserAndEvent(User user, Event event);

}
