package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;
import java.awt.*;
import java.util.*;
import java.util.List;

@Entity
public class Products {

    String title;
    String productDescription;
    String img;
   static List<Products> productsList = new ArrayList<Products>();

    static {
        productsList.add(  new Products("/images/Woodcarving.jpg", "Wood Working TEST TEST", "content here"  ));
    }

    //System.out.println();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    //this may need to change
    @ManyToOne
    ApplicationUser applicationUser;

    @ManyToOne
    Reviews review;



    public Products( String img, String title, String productDescription){
        this.img = img;
        this.title = title;
        this.productDescription = productDescription;


    }

    public List<Products> getProductsList() {
        return this.productsList;
    }





        //Products WoodWorking = new Products("/images/Woodcarving.jpg", "Wood Working", "content here"  );


    // productsList.add( Products WoodWorking = new Products("/images/Woodcarving.jpg", "Wood Working", "content here"  );






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
