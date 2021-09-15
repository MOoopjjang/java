package com.mooop.m.demo.pool.t;


import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class MPool {
    /** 수행 Thread */
    public MThread t;

    /** 작업대기열 Queue */
    public Queue<QInfo> jQueue;

    public MPool(){
        /** 작업대기열 생성 ( Queue ) */
        this.jQueue = new LinkedList<>();

        //생성시 작업 Schedule Queue를 넘겨준다.
        this.t = new MThread(jQueue);
    }

    /**
     * 작업대기열 ( Queue )에 작업셋팅
     * @param eFunc
     * @param param
     * @param <T>
     * @return
     */
    public<T> MPool push(final Consumer<T> eFunc , final T param){
        QInfo<T> qi = new QInfo<T>();
        qi.eFunc = eFunc;
        qi.param = param;
        this.jQueue.offer(qi);
        return this;
    }

    /**
     *  Thread 수행의 마지막에 실행할 기능
     *
     * @param afterFunc
     * @param param
     * @param <T>
     * @return
     */
    public<T> MPool setAfter(Consumer<T> afterFunc , T param){
        this.t.setAfter(afterFunc , param);
        return this;
    }

    public int queueCount(){
        return this.jQueue.size();
    }

    public Thread.State getState(){
        return t.getState();
    }
}
