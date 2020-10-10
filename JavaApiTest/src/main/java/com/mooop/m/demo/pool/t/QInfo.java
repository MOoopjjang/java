package com.mooop.m.demo.pool.t;

import java.util.function.Consumer;


/**
 * Thread에서 실행될 function 과 parameter 객체
 *
 * @param <T>
 */
public class QInfo<T> {

    /* 수행할 작업 function */
    public Consumer<T> eFunc;

    /* eFunc의 parameter */
    public T param;
}
