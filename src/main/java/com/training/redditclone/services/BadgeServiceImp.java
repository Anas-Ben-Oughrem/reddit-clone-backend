package com.training.redditclone.services;

import com.training.redditclone.entities.Badge;
import com.training.redditclone.repositories.BadgeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeServiceImp implements IBadgeService {


    @Autowired
    BadgeRepo badgeRepo;

    @Override

    public Badge addBadge(Badge b) {
        return  badgeRepo.save(b);
    }

    @Override
    public Badge updateBadge(Badge b) {

        return badgeRepo.save(b);
    }

    @Override
    public void deleteBadge(int idBadge) {
        Badge b = badgeRepo.findById(idBadge).get();
        badgeRepo.delete(b);

    }

    @Override
    public List<Badge> ListOfBadge() {
        return badgeRepo.findAll();
    }
}
