package com.training.redditclone.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvent;
	private String comment;
	private String name;
	private String description;
	private String organiser;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String place;
	private int attendsNumber;
	private String tags;
	@Enumerated(EnumType.STRING)
	private EventType eventType;
	/*@ManyToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private Set<Collaborator> collaborator;*/

}
