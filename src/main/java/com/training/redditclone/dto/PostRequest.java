package com.training.redditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private Long articleId;
    private String articleName;
    private String description;
}
