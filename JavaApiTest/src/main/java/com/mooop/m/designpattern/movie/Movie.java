package com.mooop.m.designpattern.movie;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;


    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }


    public Money getFee(){
        return this.fee;
    }

    public Money calculateMovieFee(Screening screening){
//        if(discountPolicy == null){
//            return fee;
//        }
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
