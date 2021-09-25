package com.mooop.m.designpattern.movie;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent , DiscountCondition... discountConditions){
        super(discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(this.percent);
    }
}
