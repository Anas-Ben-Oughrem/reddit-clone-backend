package com.training.redditclone.entities;

import javax.persistence.*;

public class Collaborators {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCollaborator;
    private String name;
    private float rating;
    @Enumerated(EnumType.STRING)
    private CollabType collabType;
    @Enumerated(EnumType.STRING)
    private Offer offer;
}
