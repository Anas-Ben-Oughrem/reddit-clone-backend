package com.training.redditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String articleName;
    private String description;
    private String userName;
    private Integer voteCount;
    private Integer commentCount;
    private String duration;
    private boolean like;
    private boolean dislike;
}
