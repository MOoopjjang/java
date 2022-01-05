package com.mooop.m.designpattern.fruit.v1.discount;

public class EventDiscount implements IDiscountConditionV1{
    @Override
    public int getDC() {
        return 5;
    }
}
