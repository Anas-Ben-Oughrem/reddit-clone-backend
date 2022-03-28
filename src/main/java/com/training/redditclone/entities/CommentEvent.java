package com.training.redditclone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class CommentEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCommentE;
	
	private String author;
	
	private String content;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@ManyToOne
	@JsonIgnore
	private Event event;
	
	@JsonIgnore
	@ManyToOne
	private User user;

}
