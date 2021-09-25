package com.mooop.m.designpattern.movie;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
