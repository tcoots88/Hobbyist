package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Review {

    String body;
    String ProductReview;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    //this may need to change
   @ManyToOne
   @JoinColumn(name = "products")
   private Products products;

   ApplicationUser applicationUser;


    public Review(ApplicationUser applicationUser, String body, String ProductReview){
        this.applicationUser = applicationUser;
        this.body = body;
        this.ProductReview = ProductReview;


    }

        public Review(){

        }

    //GETTERS
    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getProductReview() {
        return ProductReview;
    }


    public void setProducts(List<Products> productsList) {

    }
}
