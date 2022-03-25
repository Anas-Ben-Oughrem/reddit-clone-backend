package com.training.redditclone.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String description;
    private int likes;
    private  int dislikes;
    private Integer voteCount;
    private Instant createdDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> sharers;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> likers;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> dislikers;
}
