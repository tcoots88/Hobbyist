package com.example.hobbyist.hobbyist.models;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    ProductRepository productRepository;

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
        m.addAttribute("userWeAreVisiting", loggedInUser.Id);
        m.addAttribute("userWeVisited", loggedInUser);
        System.out.println("loggedInUser = " + loggedInUser);
        return "myPreferences";
    }

    @GetMapping("/reviews/{id}")
    public String showProductReviews(@PathVariable long id, Principal p, Model m){
        Products userWeAreVisiting = productRepository.findById(id).get();
//        Products loggedInUser = productRepository.findByUsername(p.getName());
        m.addAttribute("userWeAreVisiting", userWeAreVisiting);
//        m.addAttribute("loggedInUser", loggedInUser);
        return "reviews";
    }

    @GetMapping("/reviews")
    public String getAllReviews(Principal p, Model m){
        if(p != null){
            m.addAttribute("review", p);
        }
        m.addAttribute("reviews", productRepository.findAll());
        return "reviews";
    }


}
