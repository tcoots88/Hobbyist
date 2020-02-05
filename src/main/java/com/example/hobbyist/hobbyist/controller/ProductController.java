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
    public RedirectView createUserPreferences(String img, String title, String productDescription, Principal p, Model m, boolean Bonsai, boolean WoodWorking, boolean Pyrography, boolean Bonkei, boolean Fitness, boolean Sewing, boolean CandleMaking, boolean JewelryMaking, boolean Puzzles, boolean EssentialOils ) {
        if (p != null) {
            ApplicationUser userPreferences = applicationUserRepository.findByUsername(p.getName());

            if (WoodWorking) {
                Products woodworking = Products.productsList.get(0);
                woodworking.applicationUser = userPreferences;
                productRepository.save(woodworking);
//                userPreferences.savedProductsList.add(woodworking);
            }

            if (Pyrography) {
                Products pyrography = Products.productsList.get(1);
                pyrography.applicationUser = userPreferences;
                productRepository.save(pyrography);
//                userPreferences.savedProductsList.add(pyrography);
            }

            if (Bonkei) {
                Products bonkei = Products.productsList.get(2);
                bonkei.applicationUser = userPreferences;
                productRepository.save(bonkei);
//                userPreferences.savedProductsList.add(bonkei);

            }
            if (Bonsai) {
                Products bonsai = Products.productsList.get(3);
                bonsai.applicationUser = userPreferences;
                productRepository.save(bonsai);
//                userPreferences.savedProductsList.add(bonsai);


                // System.out.println(title);
            }
            if (Fitness) {
                Products fitness = Products.productsList.get(4);
                fitness.applicationUser = userPreferences;
                productRepository.save(fitness);
//                userPreferences.savedProductsList.add(fitness);

            }

            if (Sewing) {
                Products sewing = Products.productsList.get(5);
                sewing.applicationUser = userPreferences;
                productRepository.save(sewing);
//                userPreferences.savedProductsList.add(sewing);


                // System.out.println(title);
            }
            if (CandleMaking) {
                Products candlemaking = Products.productsList.get(6);
                candlemaking.applicationUser = userPreferences;
                productRepository.save(candlemaking);
//                userPreferences.savedProductsList.add(candlemaking);


                // System.out.println(title);
            }
            if (JewelryMaking) {
                Products jewelry = Products.productsList.get(7);
                jewelry.applicationUser = userPreferences;
                productRepository.save(jewelry);
//                userPreferences.savedProductsList.add(jewelry);


                // System.out.println(title);
            }
            if (Puzzles) {
                Products puzzles = Products.productsList.get(8);
                puzzles.applicationUser = userPreferences;
                productRepository.save(puzzles);
//                userPreferences.savedProductsList.add(puzzles);


                // System.out.println(title);
            }
            if (EssentialOils) {
                Products essentialoils = Products.productsList.get(9);
                essentialoils.applicationUser = userPreferences;
                productRepository.save(essentialoils);
//                userPreferences.savedProductsList.add(essentialoils);

                // System.out.println(title);
            }
            applicationUserRepository.save(userPreferences);
                // System.out.println(title);
            }
    
            return new RedirectView("/myPreferences");
        }

//        return new RedirectView("/login");

    }

