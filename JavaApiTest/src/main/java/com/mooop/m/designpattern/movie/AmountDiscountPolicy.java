package com.mooop.m.designpattern.movie;

/**
 * 할인정책...
 */
public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount , DiscountCondition... discountConditions){
        super(discountConditions);
        this.discountAmount = discountAmount;
    }


    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
