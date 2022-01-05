package com.mooop.m.designpattern.fruit.v1.discount;

import com.mooop.m.designpattern.fruit.vo.Fruit;

public class FruitDiscountV1 implements IDiscountConditionV1{
    private Fruit fruit;
    public FruitDiscountV1(Fruit fruit){
        this.fruit = fruit;
    }

    @Override
    public int getDC() {
        return 20;
    }
}
