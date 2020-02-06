package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;
import java.util.*;
import java.util.List;

@Entity
public class Products {

    String title;
    String productDescription;
    String img;
    
   public static List<Products> productsList = new ArrayList<Products>();

    static {
        productsList.add(  new Products("/images/Woodcarving.jpg", "WoodWorking", "content here"  ));
        productsList.add(  new Products("/images/Pyrography.jpg", "Pyrography", "content here"  ));
        productsList.add(  new Products("/images/bonkei.jpg", "Bonkei", "content here"  ));
        productsList.add(  new Products("/images/bonsai.jpg", "Bonsai", "content here"  ));
        productsList.add(  new Products("/images/fitness.jpg", "Fitness", "content here"  ));
        productsList.add(  new Products("/images/sewing.jpg", "Sewing", "content here"  ));
        productsList.add(  new Products("/images/CandleMaking.jpg", "CandleMaking", "content here"  ));
        productsList.add(  new Products("/images/Jewelry.jpg", "JewelryMaking", "content here"  ));
        productsList.add(  new Products("/images/puzzles.jpg", "Puzzles", "content here"  ));
        productsList.add(  new Products("/images/essentialOil.jpg", "EssentialOils", "content here"  ));
        productsList.add(  new Products("/images/lockpicking.jpg", "LockPicking", "content here"  ));
        productsList.add(  new Products("/images/leatherWorking.png", "LeatherWorking", "content here"  ));
        productsList.add(  new Products("/images/tea.jpg", "Tea", "content here"  ));

    }


    public long getId() {
        return id;
    }

    //System.out.println();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;


    //this may need to change
    @ManyToOne
    public ApplicationUser applicationUser;


    @OneToMany(cascade = CascadeType.ALL, mappedBy=  "products")
    private Set<Review> reviews;
//    Reviews review;



    public Products(String img, String title, String productDescription){
        this.img = img;
        this.title = title;
        this.productDescription = productDescription;
    }

    public Products(ApplicationUser userPreferences, String img, String title, String productDescription) {
        this.applicationUser = userPreferences;
        this.img = img;
        this.title = title;
        this.productDescription = productDescription;
    }

    public List<Products> getProductsList() {
        return this.productsList;
    }


    //Empty Constructor
    public Products(){

    }

    //GETTERS
    public String getTitle() {
        return title;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = (Set<Review>) reviews;
    }

    public String getDescription() {
        return productDescription;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

}
