package com.training.redditclone.services;


import com.training.redditclone.entities.CentreInter;
import com.training.redditclone.entities.Role;
import com.training.redditclone.entities.User;

public interface IUserService {

    void setCentreInterest(Long idUser, CentreInter centreInter);
}
