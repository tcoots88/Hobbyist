package com.example.hobbyist.hobbyist.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public RedirectView createNewApplication(String lastName,String firstName, String username, String password){

        ApplicationUser newUser = new ApplicationUser(lastName, firstName, username, passwordEncoder.encode(password));
        applicationUserRepository.save(newUser);
        return new RedirectView("/");

    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

}
