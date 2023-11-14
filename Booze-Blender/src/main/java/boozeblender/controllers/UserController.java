//package boozeblender.controllers;
//
//import boozeblender.models.User;
//import boozeblender.data.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("user")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/login")
//    public String displayUserLoginForm(Model model) {
//        model.addAttribute(new User());
//        return "user/login";
//    }
//
//    @PostMapping("/login")
//    public String processUserLoginForm(@ModelAttribute User user, Errors errors, Model model) {
//        model.addAttribute("verify", user.getVerifyPassword());
//
//        if (errors.hasErrors() || !user.getPassword().equals(user.getVerifyPassword())) {
//            if (!user.getPassword().equals(user.getVerifyPassword())) model.addAttribute("errorMsg", "User/Password does not exist!");
//            return "user/login";
//        }
//
//        return "index";
//    }
//
// @GetMapping("/register")
//    public String displayRegisterForm(Model model) {
//
//     model.addAttribute("user", new User());
//
//     return "user/register";
//    }
//
//    @PostMapping("/register")
//    public String processRegisterForm(@ModelAttribute User user, Model model) {
//
//        userRepository.save(user);
//
//        model.addAttribute("user", user);
//
//
//        return "index";
//    }
//
//
//}