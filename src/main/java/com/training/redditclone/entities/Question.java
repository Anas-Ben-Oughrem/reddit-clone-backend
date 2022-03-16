package com.training.redditclone.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String content;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="question")
    private Set<Answer> answers = new HashSet<Answer>(0);
}
