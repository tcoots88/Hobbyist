package com.example.hobbyist.hobbyist.controller;

import com.example.hobbyist.hobbyist.models.ProductRepository;
import com.example.hobbyist.hobbyist.models.Products;
import com.example.hobbyist.hobbyist.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String getHome(Principal p, Model m){
        if(p != null){
            m.addAttribute("username", p.getName());
        }
        return "home";
    }
    // Code Review Below
    // consider putting products getMapping in the products controller

    @GetMapping("/products")
    public String products(Model m) {
        List<Products> productsList = productRepository.findAll();
    m.addAttribute("productsList", productsList);
        Review oneReview = new Review();
        oneReview.setProducts(productsList);
        return "allProducts";
    }

}

