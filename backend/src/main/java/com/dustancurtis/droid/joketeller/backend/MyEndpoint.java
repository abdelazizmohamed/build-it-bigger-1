package com.dustancurtis.droid.joketeller.backend;

import com.dustancurtis.jokemaker.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(name = "myApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.joketeller.droid.dustancurtis.com", ownerName = "backend.joketeller.droid.dustancurtis.com", packagePath = ""))
public class MyEndpoint {

    public Joker myJoker = new Joker();

    @ApiMethod(name = "getJoke")
    public MyJoke getJoke() {
        MyJoke response = new MyJoke();
        response.setData(myJoker.getJoke());
        return response;
    }

}
