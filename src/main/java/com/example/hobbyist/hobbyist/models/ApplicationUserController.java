package com.example.hobbyist.hobbyist.models;

import com.example.hobbyist.hobbyist.models.ApplicationUser;
import com.example.hobbyist.hobbyist.models.ApplicationUserRepository;
import com.example.hobbyist.hobbyist.models.ProductRepository;
import com.example.hobbyist.hobbyist.models.Products;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.tools.javac.util.List;
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
        m.addAttribute("userWeAreVisiting", loggedInUser.id);
        m.addAttribute("userWeVisited", loggedInUser);
        System.out.println("loggedInUser = " + loggedInUser);
        return "myPreferences";
    }
//
    @GetMapping("/reviews/{title}")
    public String showProductReviews(@PathVariable String title, Principal p, Model m){
        ArrayList<Products> product = productRepository.findByTitle(title);
//        System.out.println("userWeAreVisiting = " + userWeAreVisiting);
        System.out.println("is this the right id" + title);
//                Products loggedInUser = productRepository.findById(id).get();
//        Products loggedInUser = productRepository.findById(p.getName());
        m.addAttribute("product", product);
//        m.addAttribute("loggedInUser", loggedInUser);
        return "reviews";
    }

//    @GetMapping("/reviews")
//    public String getAllReviews(Principal p, Model m){
//        if(p != null){
//            m.addAttribute("review", p);
//        }
//        m.addAttribute("reviews", productRepository.findAll());
//        return "reviews";
//    }


}
