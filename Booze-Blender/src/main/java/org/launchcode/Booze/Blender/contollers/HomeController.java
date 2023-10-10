package org.launchcode.Booze.Blender.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // This corresponds to your Thymeleaf HTML file named "index.html"
    }
}
