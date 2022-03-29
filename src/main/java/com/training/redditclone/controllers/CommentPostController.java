package com.training.redditclone.controllers;

import com.training.redditclone.entities.Collaborators;
import com.training.redditclone.entities.CommentPost;
import com.training.redditclone.entities.MBTIAnswer;
import com.training.redditclone.exceptions.UserNotFoundException;
import com.training.redditclone.services.CommentPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/commentPost")
@AllArgsConstructor
public class CommentPostController {
    private final CommentPostService commentPostService;

    @PostMapping("/{postId}")
    public CommentPost createCommentPost(@PathVariable Long postId,@RequestParam String content){
        return commentPostService.createCommentPost(postId, content);
    }
    @PutMapping
    public CommentPost updateCommentPost(@RequestBody CommentPost commentPost){
        return commentPostService.updateCommentPost(commentPost);
    }
    @GetMapping
    public List<CommentPost> getAllCommentPost(){
        return commentPostService.getAllCommentPost();
    }
    @GetMapping("/{id}")
    public CommentPost getCommentPostById(@PathVariable Long id){
        return commentPostService.getCommentPostById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCommentPostById(@PathVariable Long id){
        commentPostService.deleteCommentPostById(id);
    }

}