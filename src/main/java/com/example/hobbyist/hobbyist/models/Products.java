package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;
import java.util.*;
import java.util.List;

@Entity
public class Products {

    String title;
    String productDescription;



    String img;
    String review;

    
   public static List<Products> productsList = new ArrayList<Products>();

    static {

        productsList.add(  new Products("/images/soccer.jpg", "Soccer", "Get fit and improve your coordination while learning to play soccer. This kit will get you well on your way to playing the beautiful game", "This box is amazing, I have never played soccer and now I am a huge fan. Go Manchester United!"  ));

        productsList.add(  new Products("/images/knitting.jpg", "Knitting", "Learn why knitting is becoming one of the most recommended practices to fight stress. With this kit you get to create awesome wool products all while relaxing." , "" ));
        productsList.add(  new Products("/images/hiking.jpg", "Hiking", "We can't think of a better way to get fit then to explore the wilderness while hiking. This box comes with maps of your local trails and advice on pacing and safety." , "" ));

        productsList.add(  new Products("/images/Woodcarving.jpg", "WoodWorking", "Wood carving is a form of woodworking by means of a cutting tool or chisel resulting in a wooden figure or figurine", ""  ));
        productsList.add(  new Products("/images/Pyrography.jpg", "Pyrography", "The free handed art of decorating wood or other materials with burn marks resulting from the controlled application of a heated object", ""  ));
        productsList.add(  new Products("/images/bonkei.jpg", "Bonkei", "A bonkei contains no living material and is a three-dimensional depiction of a landscape in miniature, portrayed using mainly dry materials like rock, papier-mâché or cement mixtures, and sand in a shallow tray", ""  ));
        productsList.add(  new Products("/images/bonsai.jpg", "Bonsai", "A Japanese art form using cultivation techniques to produce, in containers, small trees that mimic the shape and scale of full size trees" , "" ));
        productsList.add(  new Products("/images/fitness.jpg", "Fitness", "Improve your state of health and well-being by receiving this kit to get started on your new fitness regime", ""  ));
        productsList.add(  new Products("/images/sewing.jpg", "Sewing", "The craft of fastening or attaching objects using stitches made with a needle and thread." , "" ));
        productsList.add(  new Products("/images/CandleMaking.jpg", "CandleMaking", "Everything needed to started making your own container candles, including wicks, fragrance oils and three types of wax,"  , ""));
        productsList.add(  new Products("/images/Jewelry.jpg", "JewelryMaking", "Create your own homemade jewelry with this starter including string, beads, and all the necessary tools needed to get started" , "" ));
        productsList.add(  new Products("/images/puzzles.jpg", "Puzzles", "Subscribe to this ox to receive multiple puzzles including tradition jigsaw as well as others like mechanical, mathematical, and more", ""  ));
        productsList.add(  new Products("/images/essentialOil.jpg", "EssentialOils", "An essential oil is a concentrated hydrophobic liquid containing volatile chemical compounds from plants. This box will include 12 3-oz bottles and a diffuser", ""  ));
        productsList.add(  new Products("/images/lockpicking.jpg", "LockPicking", "Lock picking is the practice of unlocking a lock by manipulating the components of the lock device without the original key.  This box includes 10 practice locks varying in difficulty along with a lockpicking kit" , "" ));
        productsList.add(  new Products("/images/leatherWorking.png", "LeatherWorking", "Leather Working is the practice of making leather into craft objects or works of art, using shaping techniques, coloring techniques or both.  With this kit, you will be able to craft your own leather products" , "" ));
        productsList.add(  new Products("/images/tea.jpg", "Tea", "This box will include 6 teas in a variety of types as well as a matcha kit, two types of infusers, and a tea set", ""  ));

    }


    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;


    @ManyToOne
    public ApplicationUser applicationUser;


    @OneToMany(cascade = CascadeType.ALL, mappedBy=  "products")
    private Set<Review> reviews;


    public Products(String img, String title, String productDescription, String review){
        this.img = img;
        this.title = title;
        this.productDescription = productDescription;
        this.review = review;
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

    public String getImg() {
        return this.img;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = (Set<Review>) reviews;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

}
