package com.training.redditclone.repositories;

import com.training.redditclone.entities.Post;
import com.training.redditclone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUser(User user);

    List<Post> findByUser_Department(String string);
}
