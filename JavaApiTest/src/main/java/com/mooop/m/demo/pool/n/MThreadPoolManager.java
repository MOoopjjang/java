package com.mooop.m.demo.pool.n;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MThreadPoolManager {

    private static final int POOL_SIZE = 10;

    private AtomicInteger nCurrentCount = new AtomicInteger(0);
    private List<MPool> poolList = null;

    private MThreadPoolManager(){
        /** 생성시점에 Pool 생성  */
        poolList = IntStream.range(0 , POOL_SIZE).mapToObj(i->new MPool()).collect(Collectors.toList());
        poolList.forEach(p->p.t.start());
    }


    /**
     *
     * @return
     */
    public static MThreadPoolManager getInstance(){
        return LazyHolder.INSTANCE;
    }


    /**
     * Pool에서 Thread를 할당하여 job을 수행한다.
     *
     * @param job
     * @param <T>
     * @throws Exception
     */
    /*
    public<T> void execute(Consumer<T> job , T param) throws Exception{
        Thread.State[] arState = (nCurrentCount.get() < ( POOL_SIZE-1) )?
                new Thread.State[]{Thread.State.WAITING}
                :new Thread.State[]{Thread.State.WAITING , Thread.State.TIMED_WAITING};

        MPool pool = poolList.stream()
                .filter(mp->Arrays.asList(arState).stream().filter(state->state == mp.getState()).count() > 0)
                .findFirst()
                .get();


        synchronized (pool.t){
            nCurrentCount.addAndGet(1);
            pool.t.execFunc(job , param).countFunc((cnt)->{
                nCurrentCount.addAndGet(-1);
            } , nCurrentCount);
            pool.t.notify();
        }
    }
     */

    public<T> void execute(Consumer<T> job , T param) throws Exception{
        Thread.State[] arState = (nCurrentCount.get() < ( POOL_SIZE-1) )?
                new Thread.State[]{Thread.State.WAITING}
                :new Thread.State[]{Thread.State.WAITING , Thread.State.TIMED_WAITING};

        MPool pool = poolList.stream()
                .filter(mp->Arrays.asList(arState).stream().filter(state->state == mp.getState()).count() > 0)
                .findFirst()
                .get();


        synchronized (pool.t){
            nCurrentCount.addAndGet(1);
            pool.t.execFunc(job , param).countFunc((cnt)->{
                nCurrentCount.addAndGet(-1);
            } , nCurrentCount);
            pool.t.notify();
        }
    }


    public int getCurrentPoolCount(){
        return this.nCurrentCount.get();
    }


    public void printThreadPoolState(){
        poolList.stream().map(MPool::getState).forEach(System.out::println);
    }


    /**
     *
     */
    private static class LazyHolder{
        private static final MThreadPoolManager INSTANCE = new MThreadPoolManager();
    }

}
