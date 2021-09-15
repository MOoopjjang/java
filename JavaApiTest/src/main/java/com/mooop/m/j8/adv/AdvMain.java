package com.mooop.m.j8.adv;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvMain {

    private static void wordCounterTest(Stream<Character> stream){
        WordCounter wordCounter = stream.reduce(new WordCounter(0 , true),
                WordCounter::accumulate,
                WordCounter::combine);

        System.out.println("count : "+wordCounter.getCounter());
    }

    private static void myWordCounterTest(Stream<Character> stream){
        MyWordCounter mwc = stream.reduce(new MyWordCounter(0 , true),
                MyWordCounter::accumlate,
                MyWordCounter::combine);
        System.out.println("mwc counter : "+mwc.getCounter());
    }

    public static void main(String[] args) {

        try{
            String s = "i am ground hihoho alala oo";
            Stream<Character> stream = IntStream.range(0 , s.length()).mapToObj(i->s.charAt(i));

//            wordCounterTest(stream);

            myWordCounterTest(stream);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
