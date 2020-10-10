package com.mooop.m.demo.pool.n;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class MPool {
    /** 수행 Thread */
    public MThread t;

    public MPool(){
        this.t = new MThread();
    }

    public Thread.State getState(){
        return t.getState();
    }
}
