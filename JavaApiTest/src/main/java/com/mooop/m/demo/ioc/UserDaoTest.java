package com.mooop.m.demo.ioc;

public class UserDaoTest {

    public static void main(String[] args) {
        UserDao dao = new DaoFactory().userDao();
    }
}
