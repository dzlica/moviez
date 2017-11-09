package hu.syntaxerror.dzlica.moviez.controllers;

import hu.syntaxerror.dzlica.moviez.model.User;
import hu.syntaxerror.dzlica.moviez.repositories.MoviezRepo;
import hu.syntaxerror.dzlica.moviez.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    MoviezRepo moviezRepo;

    @RequestMapping({"/", "/list"})
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("edituser", userRepo.findOne(id));
        return "edituser";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable long id) {
        userRepo.delete(id);
        return "redirect:/user/list";
    }

    @GetMapping(value="/add")
    public String addUser(Model model) {
        model.addAttribute("adduser", new User());
        return "adduser";
    }

    @PostMapping("/add")
    public String postUser(@ModelAttribute User user, Model model) {
        userRepo.save(user);
        model.addAttribute("users", userRepo.findAll());
        return "user";
    }

    @RequestMapping("/{id}")
    public String userlist(Model model, @PathVariable long id) {
        model.addAttribute("listmoviez", moviezRepo.findAllByUsersId(id));
        return "user";
    }


}
