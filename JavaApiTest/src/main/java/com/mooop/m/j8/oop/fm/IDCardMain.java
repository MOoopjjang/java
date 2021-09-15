package com.mooop.m.j8.oop.fm;

public class IDCardMain {

    public static void main(String[] args) {
        Factory idCardFactory = new IDCardFactory();
        Product p1 = idCardFactory.create("cwkim");
        Product p2 = idCardFactory.create("ejkim");
        Product p3 = idCardFactory.create("bhkim");
        p1.use();
        p2.use();


    }
}
