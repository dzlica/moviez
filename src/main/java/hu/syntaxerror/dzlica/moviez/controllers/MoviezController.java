package hu.syntaxerror.dzlica.moviez.controllers;

import hu.syntaxerror.dzlica.moviez.model.Moviez;
import hu.syntaxerror.dzlica.moviez.repositories.MoviezRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/moviez")
public class MoviezController {

    @Autowired
    MoviezRepo moviezRepo;

    @RequestMapping({"/", "/list"})
    public String list(Model model) {
        model.addAttribute("moviez", moviezRepo.findAll());
        return "moviez";
    }

    @GetMapping("/add")
    public String addTitle(Model model) {
        model.addAttribute("addtitle", new Moviez());
        return "add";
    }

    @PostMapping("/add")
    public String postTitle(@ModelAttribute Moviez moviez, Model model) {
        moviezRepo.save(moviez);
        model.addAttribute("moviez", moviezRepo.findAll());
        return "moviez";
    }


}
