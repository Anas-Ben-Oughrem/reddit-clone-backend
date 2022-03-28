package com.training.redditclone.services;


import com.training.redditclone.entities.*;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.repositories.CommentPostRepository;
import com.training.redditclone.repositories.PostRepository;
import com.training.redditclone.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentPostService {
    private static final String POST_URL = "";
    private final NotificationService notificationService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentPostRepository commentPostRepository;
    private final AuthService authService;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public CommentPost createCommentPost(CommentPost commentPost){
        return commentPostRepository.save(commentPost);

    }

    public CommentPost updateCommentPost(CommentPost commentPost){
        return commentPostRepository.save(commentPost);

    }
    public CommentPost getCommentPostById(Long id) {
        return commentPostRepository.findById(id)
                .orElseThrow(()->new SpringRedditException("No CommentPost was found with given id"));
    }

    public List<CommentPost> getAllCommentPost(){
        return commentPostRepository.findAll();
    }

public void deleteCommentPostById(Long id){
        commentPostRepository.deleteById(id);
}

}
