package com.dustancurtis.droid.joketeller.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.joketeller.droid.dustancurtis.com",
                ownerName = "backend.joketeller.droid.dustancurtis.com",
                packagePath = ""))

public class MyEndpoint {

    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        response.setMyJoke();
        return response;
    }

}
