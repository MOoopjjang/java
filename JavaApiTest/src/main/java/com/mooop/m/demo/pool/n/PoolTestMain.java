package com.mooop.m.demo.pool.n;

import com.mooop.m.demo.pool.n.MThreadPoolManager;

import java.util.stream.IntStream;

public class PoolTestMain {



    private static void tst1() throws Exception{

        MThreadPoolManager mtpm = MThreadPoolManager.getInstance();
        System.out.println("getCurrentPoolCount : "+mtpm.getCurrentPoolCount());

        try{
            mtpm.execute((d)->{
                System.out.println("d : "+d);
            } , "xferlog");
        }catch(Exception e){
            e.printStackTrace();
        }
        try{Thread.sleep(2000L); }catch(Exception e){}

        try{
            mtpm.execute((d)->{
                try{
                    Thread.sleep(10*1000L);
                    System.out.println("int v : "+20);

                }catch(Exception e){}

            } , 20);

            System.out.println("aaaaaaaa");
            mtpm.execute((d)->{
                System.out.println("vvvvv : "+d);
            } , "kknda");
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    private static void tst2() throws Exception{

        MThreadPoolManager mtpm = MThreadPoolManager.getInstance();
        IntStream.range(0 , 9).forEach(i->{
            try{
                mtpm.execute((data)->{
                    System.out.println("i :"+i);
                    try {
                        Thread.sleep(10*1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } , i);
                System.out.println("Thread runn : "+i+" , pool count : "+mtpm.getCurrentPoolCount());

            }catch(Exception e){
                e.printStackTrace();
            }

        });
        System.out.println("S1 --> Pool execute count : "+mtpm.getCurrentPoolCount());
        mtpm.printThreadPoolState();
//        try{Thread.sleep(1*1000L); }catch (Exception e){}

        System.out.println("=======================================================");

        System.out.println("Pool execute count : "+mtpm.getCurrentPoolCount());
        mtpm.printThreadPoolState();



        IntStream.range(0 , 9).forEach(i->{
            try{
                mtpm.execute((data)->{
                    System.out.println("i :"+i);
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } , i);
                System.out.println("Thread runn : "+i);
                System.out.println("Pool execute count : "+mtpm.getCurrentPoolCount());
            }catch(Exception e){
                e.printStackTrace();
            }

        });

        try{Thread.sleep(2*1000L); }catch (Exception e){}
        System.out.println("Last --> Pool execute count : "+mtpm.getCurrentPoolCount());

    }


    private static void tst3() throws Exception{
        MThreadPoolManager mtpm = MThreadPoolManager.getInstance();
        mtpm.execute((data)->{
            System.out.println("data : "+data);
            try{Thread.sleep(10*1000L); }catch (Exception e){}
        } , "xferlog");

        IntStream.range(1 , 20).forEach(i->{
            System.out.println("==============================================");
            mtpm.printThreadPoolState();
            try {
                Thread.sleep(1*1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }


    public static void main(String[] args) {

        try{
//            tst1();

            tst2();

//            tst3();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
