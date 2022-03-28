package com.training.redditclone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "The username is required")
    private String username;
    @NotBlank(message = "The password is required")
    private String password;
    @Email
    @NotEmpty(message = "The Email is required")
    private String email;
    private String phoneNumber;
    private String gender;
    private String department;
    private Instant createdAt;
    private int badWords;
    private boolean enabled = true;
    private int numberOfAlerts = 0;
    private String firstName;
    private String lastName;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private String role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<CommentEvent> commentsE;

    @Enumerated(EnumType.STRING)
    private CentreInter centreInter;

    @OneToMany(mappedBy = "user")
    private Set<CI> cI;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Favourite> favourites;

    @ManyToMany(mappedBy = "users" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Event> events;

}
