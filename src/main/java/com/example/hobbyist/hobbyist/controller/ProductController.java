package com.example.hobbyist.hobbyist.controller;


import com.example.hobbyist.hobbyist.models.ApplicationUser;
import com.example.hobbyist.hobbyist.models.ApplicationUserRepository;
import com.example.hobbyist.hobbyist.models.ProductRepository;
import com.example.hobbyist.hobbyist.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ProductController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    ProductRepository productRepository;

//    @PostMapping("/myPreferences")
//    public RedirectView createUserPreferences(String img, String title, String productDescription, Principal p, Model m){
//        ApplicationUser userPreferences = applicationUserRepository.findByUsername(p.getName());
//
//        Products products = new Products(userPreferences, img, title, productDescription);
//        productRepository.save(products);
//        return new RedirectView("myPreferences");
//    }

}
