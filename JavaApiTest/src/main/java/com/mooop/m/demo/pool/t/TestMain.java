package com.mooop.m.demo.pool.t;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;


/**
 * Thread Pool Test Main
 */
public class TestMain {


    private static void tst1() throws Exception{

        MThreadPoolManager mtpm = MThreadPoolManager.getInstance();
        mtpm.execute((p)->{
            System.out.println(p);
            try{
                Thread.sleep(5*1000L);
            }catch(Exception e){}
        } , "xferlog");

        System.out.println("-------------------------------------------");

        mtpm.execute((p)->{
            System.out.println(p);
            try{
                Thread.sleep(1*1000L);
            }catch(Exception e){}
        } , "a");

        mtpm.execute((p)->{
            System.out.println(p);
//            try{
//                Thread.sleep(5*1000L);
//            }catch(Exception e){}
        } , "b");

        IntStream.range(0 , 20).forEach(i->{
            mtpm.execute((p)->{
                System.out.println(i);

                System.out.println("get count : "+mtpm.getPoolCount());

            try{
                Thread.sleep(2*1000L);
            }catch(Exception e){}
            } , i);
        });


        try{Thread.sleep(20*1000L);}catch(Exception e){}





        System.out.println("------------------------ End -------------------");
    }


    private static void tst2() throws Exception{

        Integer[] ar = new Integer[]{10,1,2,3,11,9,87,6};
        Integer v = Arrays.asList(ar).stream().sorted(Comparator.comparing(Integer::intValue)).findFirst().get();
        System.out.println(v.intValue());
    }

    public static void main(String[] args) {

        try{
            tst1();
//            tst2();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
