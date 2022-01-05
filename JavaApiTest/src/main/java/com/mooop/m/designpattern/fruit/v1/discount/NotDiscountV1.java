package com.mooop.m.designpattern.fruit.v1.discount;

public class NotDiscountV1 implements IDiscountConditionV1{

    @Override
    public int getDC() {
        return 0;
    }
}
