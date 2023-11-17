package boozeblender.controllers;

import boozeblender.models.User;
import boozeblender.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String displayUserLoginForm(Model model) {
        model.addAttribute(new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String processUserLoginForm(@ModelAttribute User user, Errors errors, Model model) {
        model.addAttribute("verify", user.getVerifyPassword());

        if (errors.hasErrors() || !user.getPassword().equals(user.getVerifyPassword())) {
            if (!user.getPassword().equals(user.getVerifyPassword())) model.addAttribute("errorMsg", "User/Password does not exist!");
            return "user/login";
        }

        return "index";
    }

    @GetMapping("/register")
    public String displayRegisterForm(Model model) {

     model.addAttribute("user", new User());

     return "user/register";
    }

    @PostMapping("/register")
    public String processRegisterForm(@ModelAttribute @Valid User user, Errors errors, Model model) {

        //validate user is over 21
        //validate that passwords match

        String userBirthday = user.getBirthday();

        LocalDate birthdate = LocalDate.parse(userBirthday);

        LocalDate currentDate = LocalDate.now();

        long age = ChronoUnit.YEARS.between(birthdate, currentDate);

        if (age < 21 ) {
            errors.rejectValue("birthday", "","You must be 21 or older to sign up!" );
            return "user/register";
        }


        //check if user already exist when signing up



        // validation for fields
        if (errors.hasErrors()) {
            return "user/register";
        }


        // saving the user after validating email, username, and age and when field requirements are met
        userRepository.save(user);

        model.addAttribute("user", user);


        return "user/profile";
    }

}