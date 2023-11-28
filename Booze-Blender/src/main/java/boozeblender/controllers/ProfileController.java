package boozeblender.controllers;

import boozeblender.data.UserRepository;
import boozeblender.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;
    @GetMapping("/profile")
    public String displayProfileFrom(Model model){
        model.addAttribute(new User());
        return "user/profile";
    }

    @GetMapping("/edit")
    public String displayEditProfile(Model model, User user) {

        model.addAttribute("email", user.getEmail());
//        model.addAttribute("password", user.getPassword());
        model.addAttribute("birthday",user.getBirthday());
//        model.addAttribute("address",user.getAddress());
        return "user/edit";
    }





    @GetMapping("/delete")
    public String displayDeleteConfirmation() {
        return "user/delete";
    }

    @PostMapping("/delete")
    public String processDeleteAccount(HttpSession session) {
        User user = authenticationController.getUserFromSession(session);
//        if (user != null) {
//            // Log out the user
//            session.invalidate();
//
//            // Delete the user from the database
//            userRepository.deleteById(user.getId());
//        }
        if (user != null) {
            userRepository.deleteById(user.getId());
            session.invalidate();  // Log the user out after deletion
            return "redirect:/";  // Redirect to the home page or login page
        } else {

        }
        return "redirect:/login"; // Redirect to login page after deletion
    }

}