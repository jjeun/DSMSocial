package com.application.dsmsocial;

/**
 * Created by Owner on 9/24/2015.
 */
class User {
    int ID;
    String password;
    String email;
    String firstName;
    String lastName;
    String streetAddress;
    String City;
    String State;
    String zipCode;


    public User() {
        this.ID++;
        this.password = null;
        this.email = null;
        this.firstName = null;
        this.lastName = null;
        this.streetAddress = null;
        this.City = null;
        this.State = null;
        this.zipCode = null;
    }

    public User(String password, String email, String firstName, String lastName, String streetAddress, String City, String State, String zipCode) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.City = City;
        this.State = State;
        this.zipCode = zipCode;
    }

    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getStreetAddress(){
        return streetAddress;
    }

    public String getCity(){
        return City;
    }

    public String getState(){
        return State;
    }

    public String getZipCode(){
        return zipCode;
    }

}



