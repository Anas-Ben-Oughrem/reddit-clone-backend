package com.training.redditclone.services;

import com.training.redditclone.dto.PostRequest;
import com.training.redditclone.dto.PostResponse;
import com.training.redditclone.dto.SmsRequest;
import com.training.redditclone.entities.Post;
import com.training.redditclone.entities.NotificationEmail;
import com.training.redditclone.entities.User;
import com.training.redditclone.exceptions.PostNotFoundException;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.mappers.PostMapper;
import com.training.redditclone.repositories.PostRepository;
import com.training.redditclone.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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
    private final String[] badwords = {"bitch","ass","asshole","cunt","dick","fuck","shit"};
    private static final int maxAlerts = 5;
    private final SmsService smsService;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

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

    @Transactional(readOnly = true)
    public List<Post> getPostsByDepartment(){
        User user = authService.getCurrentUser();
        return postRepository.findByUser_Department(user.getDepartment());
    }

    public void sharePost(Long userId,Long postId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new SpringRedditException("No User found with provided id"));
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new SpringRedditException("No post was found with given id"));

        post.getSharers().add(user);

    }

    @Scheduled(fixedDelay = 60000)
    public void badwordsFilter() {
        boolean hasBadWords = false;
        System.out.println("In method Bad Words Filter ....");
        List<Post> posts = postRepository.findAll();
        for (Post post : posts) {
            List<String> description = new ArrayList<String>(Arrays.asList(post.getDescription().split(" ")));
            List<String> finalString = new ArrayList<String>();
            for (String word : description) {
                for (String badword : badwords) {
                    if (word.matches(".*" + badword + ".*")) {
                        hasBadWords = true;
                        word = "****";
                    }
                }
                finalString.add(word);
            }
            post.setDescription(String.join(" ", finalString));

            if (hasBadWords) {
                if (post.getUser().getNumberOfAlerts() < maxAlerts) {
                    String message =
                            mailContentBuilder.build(post.getUser().getUsername() + ", This email is a warning for you not meeting the appropriate behaviour inside the app. Your recent post had offensive words. A matter that we condemn in the strongest of possible terms. We hope this act never repeats itself otherwise we will be in the obligation of taking punitive measures against you");
                    sendWarningNotification(message, post.getUser());
                    post.getUser().setNumberOfAlerts(post.getUser().getNumberOfAlerts() + 1);
                    SmsRequest smsAlert = new SmsRequest(post.getUser().getPhoneNumber(),"post.getUser()" +
                            ".getUsername() + \", This sms is a warning for you not meeting the appropriate behaviour" +
                            " inside the app. Your recent post had offensive words. A matter that we condemn in the strongest of possible terms. We hope this act never repeats itself otherwise we will be in the obligation of taking punitive measures against you\"");
                    smsService.sendSms(smsAlert);
                    hasBadWords = false;
                } else {
                    post.getUser().setEnabled(false);
                }

            }
        }
    }

    private void sendWarningNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail("Behaviour Warning", user.getEmail(),
                message));
    }

    public void likePostByID(Long postId){
        User user = authService.getCurrentUser();
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new SpringRedditException("No post was found with the given id"));
        if (!post.getLikers().contains(user)){
            post.setLikes(post.getLikes() + 1);
            post.getLikers().add(user);
            postRepository.save(post);
        } else {
            throw new SpringRedditException("You have already liked this Post");
        }
    }

    public void dislikePostByID(Long postId){
        User user = authService.getCurrentUser();
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new SpringRedditException("No post was found with the given id"));
        if (!post.getLikers().contains(user)){
            post.setDislikes(post.getDislikes() + 1);
            post.getDislikers().add(user);
            postRepository.save(post);
        } else {
            throw new SpringRedditException("You have already disliked this Post");
        }
    }

    public void removeLike(Long postId){
        User user = authService.getCurrentUser();
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new SpringRedditException("No post was found with the given id"));
        if (post.getLikers().contains(user)){
            post.setLikes(post.getLikes() - 1);
            post.getLikers().remove(user);
            postRepository.save(post);
        } else {
            throw new SpringRedditException("You haven't liked this Post yet");
        }
    }

    public void removeDislike(Long postId){
        User user = authService.getCurrentUser();
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new SpringRedditException("No post was found with the given id"));
        if (post.getDislikers().contains(user)){
            post.setDislikes(post.getDislikes() - 1);
            post.getDislikers().remove(user);
            postRepository.save(post);
        } else {
            throw new SpringRedditException("You haven't liked this Post yet");
        }
    }
}
