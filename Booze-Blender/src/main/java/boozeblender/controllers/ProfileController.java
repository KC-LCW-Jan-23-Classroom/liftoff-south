package boozeblender.controllers;

import boozeblender.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class ProfileController {

    @GetMapping("/profile")
    public String displayProfileFrom(Model model){
        model.addAttribute(new User());
        return "user/profile";
    }

    @GetMapping("/edit")
    public String displayEditProfile(Model model, User user) {

        model.addAttribute("email", user.getEmail());
        //model.addAttribute("password", user.getPassword());
        model.addAttribute("birthday",user.getBirthday());
        model.addAttribute("address",user.getAddress());
        return "user/edit";
    }

}