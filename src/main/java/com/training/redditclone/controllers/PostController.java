package com.training.redditclone.controllers;

import com.training.redditclone.entities.Post;
import com.training.redditclone.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity createPost(@RequestParam String description) {
        postService.save(description);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        return status(HttpStatus.OK).body(postService.getPost(id));
    }

    @GetMapping("by-user/{username}")
    public ResponseEntity<List<Post>> getPostsByUsername(@PathVariable String username) {
        return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
    }

    @PostMapping("/add-like/{postId}")
    public void addLike(@PathVariable Long postId){
        postService.likePostByID(postId);
    }

    @PostMapping("/add-dislike/{postId}")
    public void addDislike(@PathVariable Long postId){
        postService.dislikePostByID(postId);
    }

    @PostMapping("/remove-like/{postId}")
    public void removeLike(@PathVariable Long postId){
        postService.removeLike(postId);
    }

    @PostMapping("/remove-dislike/{postId}")
    public void removeDislike(@PathVariable Long postId){
        postService.removeDislike(postId);
    }

    @PostMapping("/share/{userId}/{postId}")
    public void sharePost(@PathVariable Long userId,@PathVariable Long postId){
        postService.sharePost(userId,postId);
    }
}

