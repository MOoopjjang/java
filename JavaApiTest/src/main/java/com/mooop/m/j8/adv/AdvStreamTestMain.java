package com.mooop.m.j8.adv;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class AdvStreamTestMain {


    private static Function<Long , Long> parallelFunc = (n)->Stream.iterate(1L , i->i+1).limit(n).parallel().reduce(0L , (i,x)->i+x);
    private static Function<Long , Long> sequentialFunc = (n)->Stream.iterate(1L , i->i+1).limit(n).reduce(0L , (x,v)->x+v);
    private static Function<Long , Long> sequentialFunc2 = (n)->LongStream.rangeClosed(1 , n).reduce(0L , (x,y)->x+y);
    private static Function<Long , Long> parallelFunc2 = (n)->LongStream.rangeClosed(1 , n).parallel().reduce(0L , (x,y)->x+y);




    // n개의 숫자를 더하는 함수의 성능 측정
    private static long measureSumPerf(Function<Long , Long> adder , long n){
        long fastest = Long.MAX_VALUE;
        long start = System.nanoTime();
        long sum = adder.apply(n);
        long duration = (System.nanoTime() - start) / 1_000_000;
        if( duration < fastest){
            fastest = duration;
        }
        return fastest;
    }

    public static void main(String[] args) {
        System.out.println(" parallelFunc duration time :"+measureSumPerf(parallelFunc , 10_000_000)+" sec");
        System.out.println(" sequentialFunc duration time :"+measureSumPerf(sequentialFunc , 10_000_000)+" sec");

        System.out.println("==============================================================================");

        System.out.println("sequentialFunc2 duration time : "+measureSumPerf(sequentialFunc2 , 10_000_000)+" sec");
        System.out.println("parallelFunc2 duration time : "+measureSumPerf(parallelFunc2 , 10_000_000)+" sec");



    }
}
