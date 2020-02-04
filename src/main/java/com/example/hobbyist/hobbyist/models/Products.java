package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;

@Entity
public class Products {

    String title;
    String productDescription;
    String url;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    //this may need to change
    @ManyToOne
    ApplicationUser applicationUser;

    @ManyToOne
    Reviews review;



    public Products(ApplicationUser applicationUser, String url, String title, String productDescription){
        this.applicationUser = applicationUser;
        this.url = url;
        this.title = title;
        this.productDescription = productDescription;

    }

    //Empty Constructor
    public Products(){

    }

    //GETTERS
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return productDescription;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public Reviews getReview() {
        return review;
    }


}
