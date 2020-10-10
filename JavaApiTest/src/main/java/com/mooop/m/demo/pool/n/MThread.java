package com.mooop.m.demo.pool.n;

import java.util.function.Consumer;

public class MThread extends Thread{

    private Consumer jobFunc = null;
    private Consumer counterFunc = null;
    private Object param = null;
    private Object param2 = null;

    public<T> MThread execFunc(Consumer<T> consumer  , T param){
        this.param = param;
        this.jobFunc = consumer;
        return this;
    }

    public<T> MThread countFunc(Consumer<T> counter  , T param){
        this.counterFunc = counter;
        this.param2 = param;
        return this;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this){
                try{
                    wait();
                    System.out.println(">>> WAIT :: "+getId()+" run()<<<");
                    jobFunc.accept(param);
                    if(this.counterFunc != null && this.param2 != null){
                        this.counterFunc.accept(this.param2);
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
