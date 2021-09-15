package com.mooop.m.j8.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapFlatMapMain {


    private static void flatMapTest() throws Exception{

        System.out.println("============= flatMapTest() ================");
        ArrayList<List<Integer>> number = new ArrayList<>();
        number.add(Arrays.asList(1,2));
        number.add(Arrays.asList(3,4));
        number.add(Arrays.asList(4,3));
        number.add(Arrays.asList(5,5));


        List<Integer> intList = number.stream().flatMap(list->list.stream()).collect(Collectors.toList());
        System.out.println(intList);

    }


    private static void mapTest() throws Exception{
        System.out.println("============= mapTest() ================");
        List<String> list = Arrays.asList("xferlog" , "kknda" , "ccc" , "d");
        list.forEach(System.out::println);

        System.out.println("==========================================");
        Stream<Integer> iStream = list.stream().map(p->{
            return p.length();
        });

        List<Integer> intList = iStream.collect(Collectors.toList());
        intList.forEach(System.out::println);

    }


    public static void main(String[] args) {

        try{
            mapTest();
            flatMapTest();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
