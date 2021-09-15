package com.mooop.m.demo.ioc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class UserDao {
//    private SimpleConnectionMaker simpleConnectionMaker;
    private ConnectionnMaker connectionnMaker;

    public UserDao(ConnectionnMaker connectionnMaker){
        this.connectionnMaker = connectionnMaker;
    }


    public void add(User user) throws ClassNotFoundException , SQLException{
        Connection c = connectionnMaker.makeNewConnecyionn();

        //  구현..
    }


    public User get(String id) throws ClassNotFoundException , SQLException{
        Connection c = connectionnMaker.makeNewConnecyionn();
        //  구현..
        return new User(UUID.randomUUID().toString() , "cwkim" , "1111");
    }



//    abstract Connection getConnection() throws ClassNotFoundException , SQLException;
}
