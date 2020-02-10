package com.example.hobbyist.hobbyist.models;
// Code Review Below
// Application User Controller is in Models, for better organization try placing in controller folder.
// Bug found when trying to move application controller to controller folder, this will need to be relooked at

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public RedirectView createNewApplication(String lastName,String firstName, String username, String password){

        if(applicationUserRepository.findByUsername(username.toLowerCase()) != null){
            return new RedirectView("/signup");
        }

        ApplicationUser newUser = new ApplicationUser(lastName, firstName, username, passwordEncoder.encode(password));
        applicationUserRepository.save(newUser);
        return new RedirectView("/signup");
        }


    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/signup")
    public String showSignUpForm(){
        return "signup";
    }

    @GetMapping("/users/{id}")
    public String renderUserDetails(@PathVariable long id, Principal p, Model m){
        if(p != null){
            ApplicationUser userWeAreVisiting = applicationUserRepository.findById(id).get();
            ApplicationUser loggedInUser = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("userWeAreVisiting", userWeAreVisiting);
            m.addAttribute("loggedInUser", loggedInUser);
        }
        return "myPreferences";
    }

    @GetMapping("/myPreferences")
    public String showPreferences(Principal p, Model m){
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("loggedInUser", loggedInUser);
        m.addAttribute("userWeAreVisiting", loggedInUser.id);
        m.addAttribute("userWeVisited", loggedInUser);
        System.out.println("loggedInUser = " + loggedInUser);
        return "myPreferences";
    }

    @GetMapping("/reviews/{id}")
    public String showProductReviews(@PathVariable long id, Principal p, Model m){
        Products reviewedProduct = productRepository.findById(id).get();
        m.addAttribute("reviewedProduct", reviewedProduct);
        return "reviews";
    }
}
