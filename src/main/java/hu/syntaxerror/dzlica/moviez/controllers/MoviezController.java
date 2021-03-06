package hu.syntaxerror.dzlica.moviez.controllers;

import hu.syntaxerror.dzlica.moviez.model.Type;
import hu.syntaxerror.dzlica.moviez.model.Moviez;
import hu.syntaxerror.dzlica.moviez.model.User;
import hu.syntaxerror.dzlica.moviez.repositories.MoviezRepo;
import hu.syntaxerror.dzlica.moviez.repositories.UserRepo;
import hu.syntaxerror.dzlica.moviez.service.DateProvider;
import hu.syntaxerror.dzlica.moviez.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/moviez")
public class MoviezController {

    @Autowired
    MoviezRepo moviezRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    DateProvider dateProvider;

    @Autowired
    VoteService voteService;

    @RequestMapping({"/", "/list"})
    public String list(Model model, @RequestParam (required = false) boolean isWatched, @RequestParam(required = false) String search) {
        if (!isWatched) {
            model.addAttribute("moviez", moviezRepo.findAll());
        }
        else if (isWatched) {
            model.addAttribute("moviez", moviezRepo.findAllByWatchedIsTrue());
        }

        if (search != null) {
            model.addAttribute("moviez", moviezRepo.findAllByTitleIsLikeOrGenreIsLikeOrTypeIsLike("%" + search + "%", "%" + search + "%", "%" + search + "%"));
        }

        return "moviez";
    }

    @GetMapping("/add")
    public String addTitle(Model model) {
        model.addAttribute("addtitle", new Moviez());
        model.addAttribute("genres", Type.genres);
        model.addAttribute("types", Type.types);
        return "add";
    }

    @PostMapping("/add")
    public String postTitle(@ModelAttribute Moviez moviez, Model model, @RequestParam("duedate") String duedate) {
        moviezRepo.save(moviez);
        model.addAttribute("moviez", moviezRepo.findAll());
        return "moviez";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("editmovie", moviezRepo.findOne(id));
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("genres", Type.genres);
        model.addAttribute("types", Type.types);
        return "/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute Moviez moviez, @RequestParam("duedate") String duedate) {
        moviezRepo.save(moviez);
        return "redirect:/moviez/list";
    }

    @PostMapping("/{id}/addtofilm")
    public String addToFilm(@PathVariable long id, @RequestParam("userid") long userid) {
        Moviez moviez = moviezRepo.findOne(id);
        User user = userRepo.findOne(userid);
        moviez.addUser(user);
        moviezRepo.save(moviez);
        return "redirect:/{id}/edit";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable long id) {
        moviezRepo.delete(id);
        return "redirect:/moviez/list";
    }

    @GetMapping("/{id}/up")
    public String up(@PathVariable long id){
        voteService.upVote(id);
        return "redirect:/moviez/list";
    }

    @GetMapping("/{id}/down")
    public String down(@PathVariable long id){
        voteService.downVote(id);
        return "redirect:/moviez/list";
    }

}
