package com.training.redditclone.mappers;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.training.redditclone.dto.PostRequest;
import com.training.redditclone.dto.PostResponse;
import com.training.redditclone.entities.*;
import com.training.redditclone.repositories.CommentPostRepository;
import com.training.redditclone.repositories.VoteRepository;
import com.training.redditclone.services.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.training.redditclone.entities.VoteType.DOWNVOTE;
import static com.training.redditclone.entities.VoteType.UPVOTE;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    private CommentPostRepository commentPostRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    @Mapping(target = "like", expression = "java(isPostUpVoted(post))")
    @Mapping(target = "dislike", expression = "java(isPostDownVoted(post))")
    public abstract PostResponse mapToDto(Post post);

    Integer commentCount(Post post) {
        return commentPostRepository.findByPost(post).size();
    }

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }

    boolean isPostUpVoted(Post post) {
        return checkVoteType(post, UPVOTE);
    }

    boolean isPostDownVoted(Post post) {
        return checkVoteType(post, DOWNVOTE);
    }

    private boolean checkVoteType(Post post, VoteType voteType) {
        if (authService.isLoggedIn()) {
            Optional<Vote> voteForPostByUser =
                    voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
                            authService.getCurrentUser());
            return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType))
                    .isPresent();
        }
        return false;
    }
}
