package com.example.hobbyist.hobbyist.models;

import javax.persistence.ManyToOne;

public class Reviews {

    String body;


    //this may need to change
   @ManyToOne
   ApplicationUser applicationUser;


    public Reviews(ApplicationUser applicationUser, String body){
        this.applicationUser = applicationUser;
        this.body = body;

        }


        public Reviews(){

        }

    //GETTERS
    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public String getBody() {
        return body;
    }


}
