package com.ab.rest;

import com.ab.service.user.UserService;
import com.ab.web.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Consumes({MediaType.APPLICATION_JSON})
@Path("/user")
public class UserResource {

    @Autowired
    UserService userService;

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@QueryParam("userName") String userName,
                        @QueryParam("password") String password) {
        if("arghya".equals(userName) && "arghya".equals(password)){
            return Views.HOME;
        }
        return Views.ERROR;
    }
}