package com.training.redditclone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer idEvent;

	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String place;
	private int attendsNumber;
	private String tags;

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private EventType eventType;

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private EventNote eventNote;

	@JsonIgnore()
	private int likes;


	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> users;


	@JsonIgnore
	@ManyToMany
	private Set<Collaborators> collaborators;

	@JsonIgnore
	@OneToMany(mappedBy = "event")
	private Set<NoteE> notes;

	@JsonIgnore
	@OneToMany(mappedBy = "event")
	private Set<LikeEvent> likeEvent;

	@JsonIgnore
	@ManyToMany
	private Set<Office> offices;
}


