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

    private final NotificationService notificationService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentPostRepository commentPostRepository;
    private final AuthService authService;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public CommentPost createCommentPost(Long postId,String content){
        CommentPost comment = new CommentPost();
        comment.setText(content);
        comment.setPost(postRepository.findById(postId).get());
        comment.setUser(authService.getCurrentUser());
        String message = mailContentBuilder.build(comment.getPost().getUser().getUsername() +"Commented on your post:" +
                " " + comment.getPost().getPostId());
        notificationService.generateNotification(NotificationType.POST,message,comment.getPost().getUser());
        sendCommentNotification(message, comment.getPost().getUser());
        return commentPostRepository.save(comment);
    }

    private void sendCommentNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your article", user.getEmail(),
                message));

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