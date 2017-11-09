package hu.syntaxerror.dzlica.moviez.controllers;

import hu.syntaxerror.dzlica.moviez.model.Moviez;
import hu.syntaxerror.dzlica.moviez.model.User;
import hu.syntaxerror.dzlica.moviez.repositories.MoviezRepo;
import hu.syntaxerror.dzlica.moviez.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MoviezRestController {

    @Autowired
    MoviezRepo moviezRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/filmlist")
    public Iterable<Moviez> filmlist() {
        return moviezRepo.findAll();
    }

//    @GetMapping("/filmlist2")
//    public ArrayList<String> filmlist2() {
//        Iterable<Moviez> allmoviez = moviezRepo.findAll();
//        ArrayList<String> result = new ArrayList();
//        while (allmoviez.iterator().hasNext()) {
//            result.add(allmoviez.iterator().next().toString());
//        }
//        return result;
//    }

    @GetMapping("/film/{id}")
    public Moviez film(@PathVariable long id) {
        return moviezRepo.findOne(id);
    }

    @GetMapping("/userlist")
    public Iterable<User> userlist() {
        return userRepo.findAll();
    }

    @GetMapping("/userlist/{id}")
    public User user(@PathVariable long id) {
        return userRepo.findOne(id);
    }
}
