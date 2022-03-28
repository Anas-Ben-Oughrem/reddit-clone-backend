package com.training.redditclone.repositories;

import com.training.redditclone.entities.CommentArticle;
import com.training.redditclone.entities.CommentPost;
import com.training.redditclone.entities.Post;
import com.training.redditclone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CommentPostRepository extends JpaRepository<CommentPost,Long> {
    List<CommentPost> findByPost(Post post);

    List<CommentPost> findAllByUser(User user);
}
