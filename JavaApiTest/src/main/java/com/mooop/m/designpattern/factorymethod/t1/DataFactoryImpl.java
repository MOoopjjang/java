package com.mooop.m.designpattern.factorymethod.t1;

public class DataFactoryImpl implements IDatabaseFactory {
    Object monitor = null;
    String rdb = "Oracle";

    private DataFactoryImpl(){
        monitor = new Object();
    }

    public static DataFactoryImpl getInstance(){
        return LazyHolder.INSTANCE;
    }

    public DataFactoryImpl setRdb(String rdb){
        synchronized (monitor){
            this.rdb = rdb;
        }
        return this;
    }

    @Override
    public IDatabase getDatabase() {
        if(rdb.equals("MySql"))return new MySqlDatabaseImpl();
        else return new OracleDatabaseImpl();
    }

    private static class LazyHolder{
        private static final DataFactoryImpl INSTANCE = new DataFactoryImpl();
    }
}
