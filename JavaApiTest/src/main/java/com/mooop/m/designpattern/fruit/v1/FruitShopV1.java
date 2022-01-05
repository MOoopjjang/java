package com.mooop.m.designpattern.fruit.v0;

import com.mooop.m.designpattern.fruit.vo.Fruit;

public class FruitShopV0 {
    private static final int MAX_CUSTOMER_COUNT = 4;
    DiscountV0 discount;
    int seq;
    public FruitShopV0(){
        discount = new DiscountV0();
        seq = 0;
    }

    public boolean buy(Fruit fruit){
        seq++;
        CustomerV0 customerV0 = new CustomerV0(seq , MAX_CUSTOMER_COUNT);
        int dc = discount.getDC(fruit , customerV0);
        long result = fruit.getPrice() - calculate(dc , fruit.getPrice());
        System.out.println("========"+fruit.getKind()+", 판매 : "+result+" ==========");
        return true;
    }



    private long calculate(int dc , long price){
        return price * dc / 100;
    }
}
