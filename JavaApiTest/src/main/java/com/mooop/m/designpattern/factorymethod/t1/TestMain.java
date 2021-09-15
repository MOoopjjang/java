package com.mooop.m.designpattern.factorymethod.t1;

/**
 * FactoryMethod Pattern 테스트
 *  - 가장 핵심은 객체 생성 ( Databaes )을 위임한다.
 */
public class TestMain {

    public static void main(String[] args) {

        IDatabase db = DataFactoryImpl.getInstance().setRdb("MySql")
            .getDatabase();

        MConnection connection = db.getConnection();
        // business logic

    }
}
