package com.training.redditclone.services;

import com.training.redditclone.entities.CI;
import com.training.redditclone.entities.CentreInter;
import com.training.redditclone.entities.Role;
import com.training.redditclone.entities.User;
import com.training.redditclone.repositories.CIRepo;
import com.training.redditclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService{
    @Autowired
	UserRepository userRepository;
    @Autowired
	CIRepo ciRepo;


	@Override
	public void setCentreInterest(Long idUser, CentreInter centreInter) {
		User u = userRepository.findById(idUser).get();
		CI ci = new CI();
		ci.setCentreInterest(centreInter.toString());
		ci.setUser(u);
		ciRepo.save(ci);
		userRepository.save(u);
		
	}
}
