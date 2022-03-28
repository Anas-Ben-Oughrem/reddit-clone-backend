package com.training.redditclone.controllers;

import com.training.redditclone.entities.Collaborators;
import com.training.redditclone.services.CollaboratorsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Collaborators")
@AllArgsConstructor
public class CollaboratorsController {

    private final CollaboratorsService collaboratorsService;

    @PostMapping
    public Collaborators createCollaborators(@RequestBody Collaborators collaborators){
        return collaboratorsService.createCollaborators(collaborators);
    }

    @PutMapping
    public Collaborators updateCollaborators(@RequestBody Collaborators collaborators){
        return collaboratorsService.updateCollaborators(collaborators);
    }

    @GetMapping
    public List<Collaborators> getAllCollaborators(){
        return collaboratorsService.getAllCollaborators();
    }

    @GetMapping("/{id}")
    public Collaborators getCollaborators(@PathVariable Integer id){
        return collaboratorsService.getCollaborators(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCollaborators(@PathVariable Integer id){
        collaboratorsService.deleteCollaborators(id);
    }


}

