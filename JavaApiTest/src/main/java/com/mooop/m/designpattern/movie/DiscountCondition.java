package com.mooop.m.designpattern.movie;

/**
 * 할인 조건
 */
public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
