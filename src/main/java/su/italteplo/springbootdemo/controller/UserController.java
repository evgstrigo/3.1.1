package su.italteplo.springbootdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import su.italteplo.springbootdemo.model.User;
import su.italteplo.springbootdemo.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<User> myList = userService.findAll();
        model.addAttribute("users", myList);
        return "user-list";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("userToAdd", user);

        return "user-info-new";
    }

    @PostMapping("/")
    public String addUserAndShowAll(@ModelAttribute(name = "userToAdd") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("userToEdit", userService.findById(id));
        return "user-info-edit";
    }

    @PatchMapping("/{id}")
    public String saveEditedUser(@ModelAttribute("userToEdit") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
