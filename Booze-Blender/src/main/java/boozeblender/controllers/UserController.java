package boozeblender.controllers;

import boozeblender.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/login")
    public String displayUserLoginForm(Model model) {
        model.addAttribute(new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String processUserLoginForm(@ModelAttribute User user, Errors errors, Model model) {
        model.addAttribute("verify", user.getVerifyPassword());

        if (errors.hasErrors() || !user.getPassword().equals(user.getVerifyPassword())) {
            if (!user.getPassword().equals(user.getVerifyPassword())) model.addAttribute("errorMsg", "Passwords do not match!");
            return "user/login";
        }

        return "index";
    }

    @GetMapping("/register")
    public String displayRegisterForm(Model model) {
        model.addAttribute("username", "kg");
        model.addAttribute("birthday", "0707200");
        model.addAttribute("email", "kg@me.com");
        model.addAttribute("password", "password");
        model.addAttribute("confirmPassword", "password");
// save user input


        return "user/register";
    }

}