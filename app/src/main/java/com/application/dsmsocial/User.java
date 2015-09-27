package com.application.dsmsocial;


class User {
    String password;
    String email;
    String firstName;
    String lastName;
    String streetAddress;
    String City;
    String State;
    String zipCode;

    public void setUser(String password, String email, String firstName, String lastName, String streetAddress, String City, String State, String zipCode) {
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



