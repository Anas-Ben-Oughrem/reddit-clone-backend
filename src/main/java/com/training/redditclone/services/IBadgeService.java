package com.training.redditclone.services;

import com.training.redditclone.entities.Badge;

import java.util.List;


public interface IBadgeService {

    Badge addBadge(Badge b);

    Badge updateBadge(Badge b);

    void deleteBadge(int idBadge);

    List<Badge> ListOfBadge();

}
