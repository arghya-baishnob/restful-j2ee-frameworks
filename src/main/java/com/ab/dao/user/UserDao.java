package com.ab.dao.user;

import com.ab.dao.BaseDao;
import com.ab.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends BaseDao {

    public boolean authenticate(String email, String password) {

        final List<String> result = getSession().getNamedQuery("user.auth")
                .setString("email", email)
                .setString("password", password).list();
        if(!result.isEmpty() && result != null){
            return true;
        }
        return false;
    }

    public boolean saveUserToDB(User user) {
        if(user != null){
            getSession().persist(user);
            return true;
        }
        return false;
    }
}
