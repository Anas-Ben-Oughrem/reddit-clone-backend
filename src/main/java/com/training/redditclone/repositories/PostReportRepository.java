package com.training.redditclone.repositories;

import com.training.redditclone.entities.PostReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostReportRepository extends JpaRepository<PostReport,Long> {

    List<PostReport> findAllByIssuer_Username(String username);
}
