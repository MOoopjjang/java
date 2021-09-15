package com.mooop.m.j8.thd;

import java.util.stream.IntStream;

public class ThdMain {
    private static String text = "";




    private static void proc2(String a){
        a.chars().forEach(c->{
            text+=Character.toString((char)c);
        });
        System.out.println("id : "+Thread.currentThread().getId()+" , text : "+text);
    }



    private static void proc(String a){
        for(int i = 0; i < a.length() ; i++){
            text+=a.charAt(i);
        }

        System.out.println("id : "+Thread.currentThread().getId()+" , text : "+text);
    }

    /**
     *  가시성 테스트
     */
    private static void  visibility(){
        new Thread(()->{
            try{
                Thread.sleep(1000L);
            }catch (Exception e){}
            IntStream.range(0 , 100).forEach(i-> {
//                proc("thread1##" + i + "##");
                proc2("thread1##" + i + "##");
            });

        }).start();


        new Thread(()->{
            try{
                Thread.sleep(1000L);
            }catch (Exception e){}
            IntStream.range(0 , 100).forEach(i-> {
//                proc("thread2**" + i + "**");
                proc2("thread2**" + i + "**");
            });

        }).start();
    }

    public static void main(String[] args) {
        visibility();

    }
}
