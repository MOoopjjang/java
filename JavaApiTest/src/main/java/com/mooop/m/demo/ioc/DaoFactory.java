package com.mooop.m.demo.ioc;

public class DaoFactory {


    public UserDao userDao(){
        ConnectionnMaker connectionnMaker = new DConnectionMaker();
        return new UserDao(connectionnMaker);
    }
}
