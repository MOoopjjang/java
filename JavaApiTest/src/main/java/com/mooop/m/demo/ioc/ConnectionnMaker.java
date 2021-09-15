package com.mooop.m.demo.ioc;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionnMaker {

    public Connection makeNewConnecyionn() throws ClassNotFoundException , SQLException;
}
