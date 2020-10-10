package com.mooop.m.demo.pool.t;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  Pool Manager
 */
public class MThreadPoolManager {
    /** 최대 Thread Pool Size */
    private static final int POOL_SIZE = 10;

    /** ThreadPool 리스트 */
    private List<MPool> poolList;

    /** 현재 사용중인 ( running) Thread count */
    private AtomicInteger nPoolCount = new AtomicInteger(0);

    private MThreadPoolManager(){
        /** manager 생성시 Thread Pool 초기화 */
        poolList = IntStream.range(0 , POOL_SIZE).mapToObj(i->new MPool()).collect(Collectors.toList());
        poolList.forEach(pool->pool.t.start());
    }


    /**
     *  Singleton
     * @return
     */
    public static MThreadPoolManager getInstance(){
        return LazyHolder.INSTANCE;
    }


    /**
     * Pool의 유휴 Thread를 할당 혹은 유휴 Thread가 없을경우 대기열 ( Queue)이 가장 작은 Thread에 새로운 일을 할당한다.
     *
     * @param eFunc
     * @param param
     * @param <T>
     */
    public<T> void execute(Consumer<T> eFunc , T param){
        System.out.println("### execute() nPoolCount : "+nPoolCount.get());
        if(nPoolCount.get()  <= POOL_SIZE -1){
            MPool pool = poolList.stream()
                    .filter(mp->mp.getState() == Thread.State.WAITING)
                    .findFirst()
                    .get();

            synchronized (pool.t){
                nPoolCount.addAndGet(1);
                pool.push(eFunc , param).setAfter((counter)->{
                    nPoolCount.addAndGet(-1);
                } , nPoolCount);
                pool.t.notify();
            }
        }else{
            //모든 유휴 Thread가 존재치 않을 경우 대기열 ( Queue )이 가장 작은 Thread에 일을 할당한다.
            MPool pool = getScheduleThreadInfo();
            pool.push(eFunc , param);
        }
    }


    /**
     * Pool의 Thread중 대기열이 가장 작은 Pool 정보 반환
     *
     * @return
     */
    private MPool getScheduleThreadInfo(){
        return  poolList.stream()
                .sorted(Comparator.comparing(MPool::queueCount))
                .findFirst()
                .get();
    }

    /**
     * 현재 사용중인 Pool Count를 가져온다.
     * @return
     */
    public int getPoolCount(){
        return this.nPoolCount.get();
    }


    /**
     * LazyHolder
     */
    private static class LazyHolder{
        private final static MThreadPoolManager INSTANCE = new MThreadPoolManager();
    }
}
