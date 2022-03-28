package com.training.redditclone.repositories;

import com.training.redditclone.entities.CommentPost;
import com.training.redditclone.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CommentPostRepository extends JpaRepository<CommentPost,Long> {
    Collection<Object> findByPost(Post post);
}
