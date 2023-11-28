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

//    @GetMapping("/profile")
//    public String displayProfileFrom(Model model ){
//         model.addAttribute(new User());
//        return "user/profile";
//    }

//    @GetMapping("/edit")
//    public String displayEditProfile(Model model, User user) {
//
//        model.addAttribute("email", user.getEmail());
////        model.addAttribute("password", user.getPassword());
//        model.addAttribute("birthday",user.getBirthday());
////        model.addAttribute("address",user.getAddress());
//        return "user/edit";
//    }

    @GetMapping("/profile")
    public String displayProfile(Model model, HttpSession session) {
        User user = authenticationController.getUserFromSession(session);

        if (user != null) {
            // Retrieve additional user information from the database
            User fullUser = userRepository.findById(user.getId()).orElse(null);

            // Add user data to the model for the view
            model.addAttribute("username", fullUser.getUsername());
            model.addAttribute("email", fullUser.getEmail());
            model.addAttribute("birthday", fullUser.getBirthday());
            // Add other user-related attributes as needed

            return "user/profile";
        } else {
            // User is not logged in, handle accordingly (redirect to login, show an error message, etc.)
            return "redirect:/login";
        }
    }

//    @GetMapping("/edit")
//    public String displayEditProfile(Model model, HttpSession session) {
//        User user = authenticationController.getUserFromSession(session);
//
//        if (user != null) {
//            // Retrieve additional user information from the database
//            User fullUser = userRepository.findById(user.getId()).orElse(null);
//
//            // Add user data to the model for the view
//            model.addAttribute("email", fullUser.getEmail());
//            model.addAttribute("birthday", fullUser.getBirthday());
//            // Add other user-related attributes as needed
//
//            return "user/edit";
//        } else {
//            // User is not logged in, handle accordingly (redirect to login, show an error message, etc.)
//            return "redirect:/login";
//        }


    @GetMapping("/edit")
    public String displayEditProfile(Model model, HttpSession session) {
        User user = authenticationController.getUserFromSession(session);

        if (user != null) {
            // Retrieve additional user information from the database
            User fullUser = userRepository.findById(user.getId()).orElse(null);

            // Add user data to the model for the view
            model.addAttribute("user", fullUser);

            return "user/edit";
        } else {
            // User is not logged in, handle accordingly (redirect to login, show an error message, etc.)
            return "redirect:/login";
        }
    }

    @PostMapping("/edit")
    public String processEditProfile(@ModelAttribute User editedUser, HttpSession session, Model model) {
        // Retrieve the currently logged-in user
        User currentUser = authenticationController.getUserFromSession(session);

        if (currentUser == null) {
            // Handle the case where the user is not logged in
            return "redirect:/login";
        }

        // Update user information
        currentUser.setEmail(editedUser.getEmail());
        currentUser.setBirthday(editedUser.getBirthday());
        // Update other user-related attributes as needed

        // Save the updated user to the database
        userRepository.save(currentUser);

        // Redirect to the profile page
        return "redirect:/user/profile";
    }
}