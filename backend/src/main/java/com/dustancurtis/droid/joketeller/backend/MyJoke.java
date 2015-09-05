package com.dustancurtis.droid.joketeller.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyJoke {

    private String myJoke = "This is a joke.";

    public String getData() {
        return myJoke;
    }

    public void setData(String data) {
        myJoke = data;
    }
}