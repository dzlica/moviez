package hu.syntaxerror.dzlica.moviez.service;

import hu.syntaxerror.dzlica.moviez.repositories.MoviezRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    MoviezRepo moviezRepo;

    public void upVote(long id) {
        moviezRepo.findOne(id).setScore(moviezRepo.findOne(id).getScore() + 1);
        moviezRepo.save(moviezRepo.findOne(id));
    }

    public void downVote(long id) {
        moviezRepo.findOne(id).setScore(moviezRepo.findOne(id).getScore() - 1);
        moviezRepo.save(moviezRepo.findOne(id));
    }
}
