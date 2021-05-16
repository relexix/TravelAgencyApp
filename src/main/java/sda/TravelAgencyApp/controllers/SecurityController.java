package sda.TravelAgencyApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public ModelAndView showLogin() {
        return new ModelAndView("login");
    }
}
