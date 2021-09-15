package com.mooop.m.j8.etc;

public class MemTestMain {

    private static void default_array_test(){

        try{
            for(int i = 2 ; i >= 0 ; i--){
                int[] ar = new int[Integer.MAX_VALUE-i];
                System.out.println("ar length : "+ar.length);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }

    }


    public static void main(String[] args) {
        default_array_test();
    }
}
