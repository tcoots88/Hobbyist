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



    @PostMapping("/myPreferences")
    public RedirectView createUserPreferences(
            String img, String title, String productDescription, Principal p, Model m, Boolean Bonsai, Boolean WoodWorking, Boolean Pyrography, Boolean Bonkei, Boolean Fitness, Boolean Sewing, Boolean CandleMaking, Boolean JewelryMaking, Boolean Puzzles, Boolean EssentialOils ) {
        if (p != null) {
            ApplicationUser userPreferences = applicationUserRepository.findByUsername(p.getName());
//
//            Products products = new Products(userPreferences, img, title, productDescription);
//
//                for(int i = 0; i < 12; i++){
//
//                    if(Products.productsList.get(i).getTitle() == true){
//
//                        productRepository.save(Products.productsList.get(i));
//                    }
//
//                }


            if (WoodWorking) {
                Products woodworking = Products.productsList.get(0);

                productRepository.save(woodworking);
                // System.out.println(title);
            }

            if (Pyrography) {
                Products bonsai = Products.productsList.get(1);

                productRepository.save(bonsai);
                // System.out.println(title);
            }
//
            if (Bonkei) {
                 Products bonkei = Products.productsList.get(2);

               productRepository.save(bonkei);
               // System.out.println(title);
            }
            if (Bonsai) {
                Products bonsai = Products.productsList.get(3);

                productRepository.save(bonsai);
                // System.out.println(title);
            }
            if (Fitness) {
                Products fitness = Products.productsList.get(4);

                productRepository.save(fitness);
                // System.out.println(title);
            }

            if (Sewing) {
                Products sewing = Products.productsList.get(5);

                productRepository.save(sewing);
                // System.out.println(title);
            }
            if (CandleMaking) {
                Products candlemaking = Products.productsList.get(6);

                productRepository.save(candlemaking);
                // System.out.println(title);
            }
            if (JewelryMaking) {
                Products jewelry = Products.productsList.get(7);

                productRepository.save(jewelry);
                // System.out.println(title);
            }
            if (Puzzles) {
                Products puzzles = Products.productsList.get(8);

                productRepository.save(puzzles);
                // System.out.println(title);
            }
            if (EssentialOils) {
                Products essentialoils = Products.productsList.get(9);

                productRepository.save(essentialoils);
                // System.out.println(title);
            }


            return new RedirectView("/myPreferences");
        }

        return new RedirectView("/login");

    }
}
