package com.training.redditclone.controllers;

import com.training.redditclone.entities.PostReport;
import com.training.redditclone.services.PostReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportPost")
@AllArgsConstructor
public class PostReportController {

    private final PostReportService postReportService;

    @PostMapping
    public PostReport reportPost(@RequestBody PostReport postReport){
        return postReportService.addPostReport(postReport);
    }

    @PutMapping
    public PostReport updateReport(@RequestBody PostReport postReport){
        return postReportService.updatePostReport(postReport);
    }

    @DeleteMapping("/{reportId}")
    public void deleteReport(@PathVariable Long reportId){
        postReportService.deletePostReport(reportId);
    }

    @GetMapping("/{username}")
    public List<PostReport> getPostReportsByUsername(@PathVariable String username){
        return postReportService.getAllPostReportsByUsername(username);
    }
}
