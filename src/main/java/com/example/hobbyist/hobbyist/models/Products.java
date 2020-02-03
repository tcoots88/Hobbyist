package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;

@Entity
public class Products {

    String title;
    String description;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    //this may need to change
    @ManyToOne
    ApplicationUser applicationUser;

    @ManyToOne
    Reviews review;



    public Products(ApplicationUser applicationUser, Reviews review, String title, String description){
        this.applicationUser = applicationUser;
        this.title = title;
        this.description = description;
        this.review = review;

    }

    //Empty Constructor
    public Products(){

    }

    //GETTERS
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public Reviews getReview() {
        return review;
    }


}
