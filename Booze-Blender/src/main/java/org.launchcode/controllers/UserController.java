package org.launchcode.controllers;





import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class UserController {

    @GetMapping("/login")
    public String displayUserLoginForm(Model model) {

        model.addAttribute("Login",new User());
        return "login";
    }

    @PostMapping("/login")
public String processUserLoginForm(@ModelAttribute User user, Errors errors, Model model) {

    model.addAttribute("verify", user.getVerifyPassword());

    if (errors.hasErrors() || !user.getPassword().equals(user.getVerifyPassword())) {
        if (!user.getPassword().equals(user.getVerifyPassword()))

            model.addAttribute("errorMsg", "Passwords do not match!");

        return "login";
    } else {

        return "index";
    }
}

}