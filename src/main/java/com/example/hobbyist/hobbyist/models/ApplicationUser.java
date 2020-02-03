package com.example.hobbyist.hobbyist.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ApplicationUser {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;


    @OneToMany(mappedBy = "applicationUser")
    List<Products> savedProductsList;

    //getter for product list
    public List<Products>getProductList(){

        return this.savedProductsList;
    }


    String username;
    String password;
    String firstName;
    String lastName;


    public ApplicationUser(String lastName, String firstName,String username, String password){
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.password = password;

    }

        // Empty constructor
        public ApplicationUser(){

        }

        //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }


}
