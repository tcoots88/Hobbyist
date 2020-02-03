package com.example.hobbyist.hobbyist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicationUser {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    String lastName;
    String firstName;
    String username;
    String password;


    public ApplicationUser(String lastName, String firstName, String username, String password){
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
