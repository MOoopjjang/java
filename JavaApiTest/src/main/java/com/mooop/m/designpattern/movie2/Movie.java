package com.mooop.m.designpattern.movie2;


import com.mooop.m.designpattern.movie.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public boolean isDiscountable(LocalDateTime whenScreened , int sequence){
        for(DiscountCondition discountCondition:discountConditions){
            if(discountCondition.getType() == DiscountConditionType.PERIOD){
                if(discountCondition.isDiscountable(whenScreened.getDayOfWeek() , whenScreened.toLocalTime())){
                    return true;
                }
            }else{
                if(discountCondition.isDiscountable(sequence)){
                    return true;
                }
            }
        }
        return false;
    }

    public Money calculateAmountDiscountedFee(){
        if(this.movieType != MovieType.AMOUNT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(this.discountAmount);
    }


    public Money calculatePercentDiscountedFee(){
        if(this.movieType != MovieType.PERCENT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee(){
        if(this.movieType != MovieType.NONE_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee;
    }



    /*
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions);
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

     */
}
