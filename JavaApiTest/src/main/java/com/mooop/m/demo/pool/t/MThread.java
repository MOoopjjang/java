package com.mooop.m.demo.pool.t;

import java.util.Queue;
import java.util.function.Consumer;

public class MThread extends Thread{
    Queue<QInfo> queue;
    Consumer afterFunc = null;
    Object param = null;


    public MThread(Queue<QInfo> queue){
        this.queue = queue;
    }

    public<T> void setAfter(Consumer<T> afterFunc , T param){
        this.afterFunc = afterFunc;
        this.param = param;
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            synchronized (this){
                try{
                    wait();

                    /** Queue의 작업들 수행  */
                    while(!this.queue.isEmpty()){
                        QInfo qi = this.queue.poll();
                        qi.eFunc.accept(qi.param);
                    }

                    /** 사용중인 pool count를 감소시킨다. */
                    if(this.afterFunc != null && this.param != null){
                        this.afterFunc.accept(this.param);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
