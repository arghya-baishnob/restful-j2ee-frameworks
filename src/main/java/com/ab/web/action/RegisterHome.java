package com.ab.web.action;

import com.ab.model.user.Address;
import com.ab.model.user.User;
import com.ab.service.user.UserService;
import com.ab.web.Views;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/register")
@Results({
        //@Result(name= Views.SIGN_UP, location="/demo/register/create.tiles"),
        @Result(name= Views.LOGIN, location="/pages/user/login.jsp"),
})
public class RegisterHome extends BaseHome {

    private static final Logger logger = Logger.getLogger(RegisterHome.class);

    private User user;
    private Address address;

    @Autowired
    UserService userService;

    @Action("createForm")
    public String createForm() {
        return Views.SIGN_UP;
    }

    @Action("create")
    public String create() {
        logger.info("Sign Up ........" + user.getEmail() + "--" + address.getAddress1());
        if(user != null && address != null){
            logger.info("here ........");
            user.setAddress(address);
            userService.saveUser(user);
        }
        return Views.LOGIN;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
