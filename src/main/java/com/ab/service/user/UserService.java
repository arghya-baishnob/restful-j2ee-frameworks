package com.ab.service.user;

import com.ab.dao.user.UserDao;
import com.ab.model.user.User;
import com.ab.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends BaseService {

    @Autowired
    UserDao userDao;

    @Transactional
    public boolean authenticate(String email, String password) {
        return userDao.authenticate(email, password);
    }

    @Transactional
    public boolean saveUser(User user) {
        return userDao.saveUserToDB(user);
    }

}
