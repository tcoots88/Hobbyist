package com.example.hobbyist.hobbyist.controller;

import com.example.hobbyist.hobbyist.models.ApplicationUser;
import com.example.hobbyist.hobbyist.models.Products;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Principal p, Model m){
        if(p != null){
            m.addAttribute("username", p.getName());
        }
        return "home";
    }

    @GetMapping("/products")
    public String products(Model m) {
        List<Products> productsList = new Products().getProductsList();
    m.addAttribute("productsList", productsList);
        return "allProducts";
    }
}
