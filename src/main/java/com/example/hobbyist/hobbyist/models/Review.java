package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Review {

    String body;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    //this may need to change
   @ManyToOne
   @JoinColumn(name = "products")
   private Products products;

   ApplicationUser applicationUser;

    public Review(ApplicationUser applicationUser, String body){
        this.applicationUser = applicationUser;
        this.body = body;

        }

        public Review(){

        }

    //GETTERS
//    public ApplicationUser getApplicationUser() {
//        return applicationUser;
//    }

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }


    public void setProducts(List<Products> productsList) {

    }
}
