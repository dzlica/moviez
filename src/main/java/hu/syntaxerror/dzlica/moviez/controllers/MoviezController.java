package hu.syntaxerror.dzlica.moviez.controllers;

import hu.syntaxerror.dzlica.moviez.repositories.MoviezRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/moviez")
public class MoviezController {

    @Autowired
    MoviezRepo moviezRepo;

    @RequestMapping({"/", "/list"})
    public String list(Model model) {
        model.addAttribute("movies", moviezRepo.findAll());
        return "moviez";
    }

}
