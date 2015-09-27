package com.application.dsmsocial;

/**
 * Created by Owner on 9/26/2015.
 */
public class usersFakeDB {

    User[] users = new User[3];

    public void initializeDB()
    {
        this.users[0].setUser("123", "maxwell.kindred@drake.edu", "Max", "Kindred", "2414 Drake Park Avenue", "Des Moines", "Iowa", "50311");
        this.users[1].setUser("password", "danthedad@gmail.com", "Dan", "the Dad", "Dan's house", "Dadville", "Iowa", "50311");
        this.users[2].setUser("art", "elisetheartist@etsy.com", "Elise", "Johnson", "561 East 14th Street", "Des Moines", "Iowa", "50311");
    }
}
