package com.mooop.m.j8.thd;

import java.util.concurrent.CompletableFuture;

public class ThdMain2 {


    private static void tst1(){
        System.out.println("start");
        CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(5000L);
            }catch (Exception e){}

            System.out.println("runAsync");
        }).thenRun(()->System.out.println("thenRun"));
        System.out.println("end");
    }

    public static void main(String[] args) {
        tst1();
        try {
            Thread.sleep(10000L);
        }catch (Exception e){}
    }
}
