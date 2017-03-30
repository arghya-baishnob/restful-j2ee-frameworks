package com.ab.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
}
