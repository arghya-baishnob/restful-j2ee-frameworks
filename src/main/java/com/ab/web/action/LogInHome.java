package com.ab.web.action;

import com.ab.model.user.User;

import com.ab.service.user.UserService;
import com.ab.web.Views;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;


@Namespace("/")
@Results({
        @Result(name= Views.LOGIN, location="/pages/user/login.jsp"),
        @Result(name= Views.HOME, location="/pages/home/home.jsp"),
        @Result(name= Views.ERROR, location="/pages/error/error.jsp")
})
public class LogInHome extends BaseHome {

    private static final Logger logger = Logger.getLogger(LogInHome.class);

    private User user;

    @Autowired
    UserService userService;

    @Action("/")
    public String createForm(){ return Views.LOGIN; }

    @Action("/login")
    public String login(){
        if(userService.authenticate(user.getEmail(), user.getPassword())){
            return Views.HOME;
        }
        return Views.ERROR;
    }

    public User getUser() { return user; }
    public void setUser(User user) {
        this.user = user;
    }
}
