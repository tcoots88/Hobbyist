package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;
import java.util.*;
import java.util.List;

@Entity
public class Products {

    String title;
    String productDescription;



    String img;
    String ProductReview;
   // code review below
   // hard coded reviews in product should be made dynamic

   public static List<Products> productsList = new ArrayList<Products>();

    static {
        productsList.add(  new Products("/images/Woodcarving.jpg", "WoodWorking", "Wood carving is a form of woodworking by means of a cutting tool or chisel resulting in a wooden figure or figurine", "I've always wanted to get into wood working but was intimidated by the cost, this box was perfect! I now have a cool project I am proud of. "  ));
        productsList.add(  new Products("/images/Pyrography.jpg", "Pyrography", "The free handed art of decorating wood or other materials with burn marks resulting from the controlled application of a heated object", "I had never even hear of Pyrography before, but boy is this cool! Highly recomended"  ));
        productsList.add(  new Products("/images/bonkei.jpg", "Bonkei", "A bonkei contains no living material and is a three-dimensional depiction of a landscape in miniature, portrayed using mainly dry materials like rock, papier-mâché or cement mixtures, and sand in a shallow tray", "It was so much fun to make a Bonkei tree with my kids. It's a little bit messy if your worried about that, but a ton of fun!"  ));
        productsList.add(  new Products("/images/bonsai.jpg", "Bonsai", "A Japanese art form using cultivation techniques to produce, in containers, small trees that mimic the shape and scale of full size trees" , "I can now say I own a Bonzai tree! Not only is the tree awesome, but learning about the culture and importance around it was very interesting" ));
        productsList.add(  new Products("/images/fitness.jpg", "Fitness", "Improve your state of health and well-being by receiving this kit to get started on your new fitness regime", "This is perfect for anyone who doesn't have time to make it into the gym, or just doesn't like going to the gym. A fun new workout style has re charged my workouts at home!"  ));
        productsList.add(  new Products("/images/sewing.jpg", "Sewing", "The craft of fastening or attaching objects using stitches made with a needle and thread." , "As someone who's always outdoors i've always wanted to learn to sew. This skill has already came in handy when climbing mt rainer I had a rip in my tent that I was able to sew!" ));
        productsList.add(  new Products("/images/CandleMaking.jpg", "CandleMaking", "Everything needed to started making your own container candles, including wicks, fragrance oils and three types of wax,"  , "This was a ton of fun! Also, works perfect for gifts for loved ones at the holidays. "));
        productsList.add(  new Products("/images/Jewelry.jpg", "JewelryMaking", "Create your own homemade jewelry with this starter including string, beads, and all the necessary tools needed to get started" , "I bought this box for my teenagers, they loved making the jewelry and showing off to their friends something they made." ));
        productsList.add(  new Products("/images/puzzles.jpg", "Puzzles", "Subscribe to this ox to receive multiple puzzles including tradition jigsaw as well as others like mechanical, mathematical, and more", "I recently got into playing puzzles and this site got me hooked constantly, thanks to their product."));
        productsList.add(  new Products("/images/essentialOil.jpg", "EssentialOils", "An essential oil is a concentrated hydrophobic liquid containing volatile chemical compounds from plants. This box will include 12 3-oz bottles and a diffuser", "Great price for the quantity. Highly recommended."  ));
        productsList.add(  new Products("/images/lockpicking.jpg", "LockPicking", "Lock picking is the practice of unlocking a lock by manipulating the components of the lock device without the original key.  This box includes 10 practice locks varying in difficulty along with a lockpicking kit" , "I never knew I could be this good at lock picking. I will definitely choose this product again!" ));
        productsList.add(  new Products("/images/leatherWorking.png", "LeatherWorking", "Leather Working is the practice of making leather into craft objects or works of art, using shaping techniques, coloring techniques or both.  With this kit, you will be able to craft your own leather products" , "My leather working skills improved tremendously thanks for sending me this product guys." ));
        productsList.add(  new Products("/images/tea.jpg", "Tea", "This box will include 6 teas in a variety of types as well as a matcha kit, two types of infusers, and a tea set", "I absolutely love this product. Best decision made so far"  ));
        productsList.add(  new Products("/images/soccer.jpg", "Soccer", "Get fit and improve your coordination while learning to play soccer. This kit will get you well on your way to playing the beautiful game", "This box is amazing, I have never played soccer and now I am a huge fan. Go Manchester United!"  ));
        productsList.add(  new Products("/images/knitting.jpg", "Knitting", "Learn why knitting is becoming one of the most recommended practices to fight stress. With this kit you get to create awesome wool products all while relaxing." , "I love how they sent me instructions to get started." ));
        productsList.add(  new Products("/images/hiking.jpg", "Hiking", "We can't think of a better way to get fit then to explore the wilderness while hiking. This box comes with maps of your local trails and advice on pacing and safety." , "This box gives me the idea of different trails around my city." ));

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

 // Code Review
 // Duplicate work here you could use one constructor here and just leave the application user null to start

    public Products(String img, String title, String productDescription, String ProductReview){
        this.img = img;
        this.title = title;
        this.productDescription = productDescription;
        this.ProductReview = ProductReview;
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

    public String getProductReview() {
        return ProductReview;
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
