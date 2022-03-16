package com.training.redditclone.services;

import com.training.redditclone.dto.PostRequest;
import com.training.redditclone.dto.PostResponse;
import com.training.redditclone.entities.Post;
import com.training.redditclone.entities.User;
import com.training.redditclone.exceptions.PostNotFoundException;
import com.training.redditclone.mappers.PostMapper;
import com.training.redditclone.repositories.PostRepository;
import com.training.redditclone.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final AuthService authService;
    private final PostMapper postMapper;
    private final UserRepository userRepository;

    public Post save(PostRequest postRequest) {
        User currentUser = authService.getCurrentUser();
        return postMapper.map(postRequest, currentUser);
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream().map(postMapper::mapToDto)
                .collect(toList());
    }
}
