package com.training.redditclone.services;

import com.training.redditclone.entities.Collaborators;
import com.training.redditclone.exceptions.SpringRedditException;
import com.training.redditclone.repositories.CollaboratorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CollaboratorsService {

    private final CollaboratorsRepository collaboratorsRepository;

    public Collaborators createCollaborators(Collaborators collaborators){
        return collaboratorsRepository.save(collaborators);
    }

    public Collaborators updateCollaborators(Collaborators collaborators){
        return collaboratorsRepository.save(collaborators);
    }


    public List <Collaborators> getAllCollaborators(){
        return collaboratorsRepository.findAll();
    }

    public Collaborators getCollaborators(Integer id){
        return collaboratorsRepository.findById(id)
                .orElseThrow(()->new SpringRedditException("No Collaborator was found with given id"));
    }

    public void deleteCollaborators(Integer id) {
        collaboratorsRepository.deleteById(id);
    }

}
