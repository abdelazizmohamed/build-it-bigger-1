package com.dustancurtis.droid.joketeller.backend;

import com.dustancurtis.jokemaker.Joker;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private static Joker joker;
    private String myJoke;

    public String getMyJoke() {
        return myJoke;
    }

    public void setMyJoke() {
        myJoke = joker.getJoke();
    }
}