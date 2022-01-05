package com.mooop.m.designpattern.fruit.v1;

import com.mooop.m.designpattern.fruit.v1.discount.IDiscountConditionV1;
import com.mooop.m.designpattern.fruit.v1.policy.DiscountPolicyV1;
import com.mooop.m.designpattern.fruit.vo.Fruit;

public class DiscountV1 {

    private DiscountPolicyV1 discountPolicy;
    public DiscountV1(DiscountPolicyV1 discountPolicy){
        this.discountPolicy = discountPolicy;
    }

    public int getDC(Fruit fruit, CustomerV1 customer){
        return discountPolicy.createDiscountList(fruit , customer)
            .stream()
            .map(IDiscountConditionV1::getDC)
            .reduce(0 , Integer::sum);
    }
}
