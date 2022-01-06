package com.mooop.m.designpattern.fruit.v0;

import com.mooop.m.designpattern.fruit.vo.Fruit;

import java.util.Arrays;

/**
 *  판매상
 */
public class FruitSellerV0 {
    private long totalAmount;
    private DiscountV0 discount;

    public FruitSellerV0(DiscountV0 discount){
        this.discount = discount;
        this.totalAmount = 0;
    }


    /**
     * 과일을 판다.
     *
     * @param customer
     * @param fruits
     */
    public void sellTo(CustomerV0 customer , Fruit... fruits){
        long reqAmount = Arrays.asList(fruits).stream().map(fruit -> calculate(fruit , customer))
            .reduce(0L , Long::sum);

        System.out.println("sellTo -> reqAmount : "+reqAmount);
        if(customer.calculateFruit(reqAmount) != -1){
            totalAmount += reqAmount;
            customer.receiveFruits(fruits);
        }
        System.out.println("sellTo() totalAmount : "+this.totalAmount);

    }

    /**
     * 션택한 과일의 가격을 계산한다.
     * @param fruit
     * @return
     */
    private long calculate(Fruit fruit , CustomerV0 customer){
        return fruit.getPrice() - (fruit.getPrice() * discount.calculateDCPercent(fruit , customer.getSeq()) / 100);
    }
}
