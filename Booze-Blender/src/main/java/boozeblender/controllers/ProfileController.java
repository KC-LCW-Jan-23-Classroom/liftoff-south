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
public class ProfileController {
    @GetMapping("/profile")
    public String displayProfileFrom(Model model) {
        model.addAttribute(new User());
        return "user/profile";
    }

    @PostMapping("/profile")
    public String processUserProfileForm(@ModelAttribute User user, Errors errors, Model model) {

        model.addAttribute("verify", user.getVerifyPassword());

        if (errors.hasErrors() || !user.getPassword().equals(user.getVerifyPassword())) {
            if (!user.getPassword().equals(user.getVerifyPassword())) model.addAttribute("errorMsg", "Passwords do not match!");
            return "user/profile";
        }

        return "redirect:";

    }
}