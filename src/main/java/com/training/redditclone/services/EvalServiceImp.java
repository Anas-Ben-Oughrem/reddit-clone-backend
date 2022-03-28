package com.training.redditclone.services;

import com.training.redditclone.entities.Eval;
import com.training.redditclone.repositories.EvalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvalServiceImp implements IEvalService{
    @Autowired
    EvalRepo evalRepo ;

    @Override
    public Eval addEval(Eval e) {
        return evalRepo.save(e);
    }

    @Override
    public Eval updateEval(Eval eval) {

        return evalRepo.save(eval);
    }

    @Override
    public void deleteEval(int idEval) {
        Eval eval = evalRepo.findById(idEval).get();
        evalRepo.delete(eval);

    }

    @Override
    public List<Eval> ListOfEval() {
        return evalRepo.findAll();
    }
}
