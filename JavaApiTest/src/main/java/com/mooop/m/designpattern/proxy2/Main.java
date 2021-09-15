package com.mooop.m.designpattern.proxy2;

public class Main {

    public static void main(String[] args) {
        IPerson personController = new ProxyPerson();

        System.out.println("================ set ===============");
        personController.setPersonInfo(new PersonInfo("cwkim" , 10 , "incheon"));
        personController.setPersonInfo(new PersonInfo("ejkim" , 20 , "incheon"));
        System.out.println("================ first get ===============");
        long start = System.nanoTime();
        PersonInfo p = personController.getPersonInfo("cwkim");
        System.out.println("duration : "+(System.nanoTime() - start)+" , result : "+p.toString());
        System.out.println("================ second get ===============");
        start = System.nanoTime();
        p = personController.getPersonInfo("cwkim");
        System.out.println("duration : "+(System.nanoTime() - start)+" , result : "+p.toString());

    }
}
