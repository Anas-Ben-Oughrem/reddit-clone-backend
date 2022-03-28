package com.training.redditclone.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class EventImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idImage;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	
	

	public EventImage(String name, Event event) {
		this.name = name;
		this.event = event;
	}

	public EventImage() {
	}
	

}
