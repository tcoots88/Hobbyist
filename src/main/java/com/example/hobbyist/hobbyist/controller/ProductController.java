package com.example.hobbyist.hobbyist.controller;


import com.example.hobbyist.hobbyist.models.ApplicationUser;
import com.example.hobbyist.hobbyist.models.ApplicationUserRepository;
import com.example.hobbyist.hobbyist.models.ProductRepository;
import com.example.hobbyist.hobbyist.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ProductController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/cart/{id}")
    public String getHome(@PathVariable long id, Principal p, Model m){
        Products checkout = productRepository.findById(id).get();
        m.addAttribute("checkout", checkout);
        return "cart";
    }


    @PostMapping("/myPreferences/addToCart/{id}")
    public RedirectView checkout(@PathVariable long id, Model m, Principal p){
       Products checkout = productRepository.findById(id).get();
        m.addAttribute("checkout", checkout);
        return new RedirectView("/cart/" + checkout.getId());
    }

    @PostMapping("/myPreferences/delete/{id}")
    public RedirectView delete(@PathVariable long id){
        productRepository.deleteById(id);
        return new RedirectView("/myPreferences");
    }


    @PostMapping("/myPreferences")
    public RedirectView createUserPreferences(String img, String title, String productDescription, Principal p, Model m, boolean Bonsai, boolean WoodWorking, boolean Pyrography, boolean Bonkei, boolean Fitness, boolean Sewing, boolean CandleMaking, boolean JewelryMaking, boolean Puzzles, boolean EssentialOils, boolean LockPicking, boolean LeatherWorking, boolean Tea , boolean Soccer, boolean Knitting, boolean Hiking) {
        if (p != null) {
            ApplicationUser userPreferences = applicationUserRepository.findByUsername(p.getName());

            if (WoodWorking) {
                Products woodworking = Products.productsList.get(0);
                woodworking.applicationUser = userPreferences;
                productRepository.save(woodworking);
            }

            if (Pyrography) {
                Products pyrography = Products.productsList.get(1);
                pyrography.applicationUser = userPreferences;
                productRepository.save(pyrography);
            }

            if (Bonkei) {
                Products bonkei = Products.productsList.get(2);
                bonkei.applicationUser = userPreferences;
                productRepository.save(bonkei);
            }

            if (Bonsai) {
                Products bonsai = Products.productsList.get(3);
                bonsai.applicationUser = userPreferences;
                productRepository.save(bonsai);
            }

            if (Fitness) {
                Products fitness = Products.productsList.get(4);
                fitness.applicationUser = userPreferences;
                productRepository.save(fitness);
            }

            if (Sewing) {
                Products sewing = Products.productsList.get(5);
                sewing.applicationUser = userPreferences;
                productRepository.save(sewing);
            }

            if (CandleMaking) {
                Products candlemaking = Products.productsList.get(6);
                candlemaking.applicationUser = userPreferences;
                productRepository.save(candlemaking);
            }

            if (JewelryMaking) {
                Products jewelry = Products.productsList.get(7);
                jewelry.applicationUser = userPreferences;
                productRepository.save(jewelry);
            }

            if (Puzzles) {
                Products puzzles = Products.productsList.get(8);
                puzzles.applicationUser = userPreferences;
                productRepository.save(puzzles);
            }

            if (EssentialOils) {
                Products essentialoils = Products.productsList.get(9);
                essentialoils.applicationUser = userPreferences;
                productRepository.save(essentialoils);
            }
            if (LockPicking) {
                Products lockpicking = Products.productsList.get(10);
                lockpicking.applicationUser = userPreferences;
                productRepository.save(lockpicking);
            }
            if (LeatherWorking) {
                Products leatherworking = Products.productsList.get(11);
                leatherworking.applicationUser = userPreferences;
                productRepository.save(leatherworking);
            }
            if (Tea) {
                Products tea = Products.productsList.get(12);
                tea.applicationUser = userPreferences;
                productRepository.save(tea);
            }
            if (Soccer) {
                Products soccer = Products.productsList.get(13);
                soccer.applicationUser = userPreferences;
                productRepository.save(soccer);
            }
            if (Knitting) {
                Products knitting = Products.productsList.get(14);
                knitting.applicationUser = userPreferences;
                productRepository.save(knitting);
            }
            if (Hiking) {
                Products hiking = Products.productsList.get(15);
                hiking.applicationUser = userPreferences;
                productRepository.save(hiking);
            }






            applicationUserRepository.save(userPreferences);
            }
    
            return new RedirectView("/myPreferences");
        }

    }


