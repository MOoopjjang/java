package com.mooop.m.designpattern.fruit.v1;

import com.mooop.m.designpattern.fruit.v1.policy.DiscountPolicyV1;
import com.mooop.m.designpattern.fruit.vo.Fruit;

public class FruitShopV1 {

    DiscountV1 discount;
    int seq;
    public FruitShopV1(){
        discount = new DiscountV1(new DiscountPolicyV1());
        seq = 0;
    }

    public boolean buy(Fruit fruit){
        seq++;
        CustomerV1 customer = new CustomerV1(seq);
        int dc = discount.getDC(fruit , customer);
        long result = fruit.getPrice() - calculate(dc , fruit.getPrice());
        System.out.println("========"+fruit.getKind()+", 판매 : "+result+" ==========");
        return true;
    }


    private long calculate(int dc , long price){
        return price * dc / 100;
    }
}
