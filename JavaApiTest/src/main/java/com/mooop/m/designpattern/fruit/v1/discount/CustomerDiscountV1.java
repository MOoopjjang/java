package com.mooop.m.designpattern.fruit.v1.discount;

import com.mooop.m.designpattern.fruit.v1.CustomerV1;

public class CustomerDiscountV1 implements IDiscountConditionV1{
    private CustomerV1 customer;
    public CustomerDiscountV1(CustomerV1 customer){
        this.customer = customer;
    }

    @Override
    public int getDC() {
        int dc = 0;
        if(customer.isFirstAndLast()){
            dc += 30;
        }else{
            if(customer.isFirst())dc+=10;
            else if(customer.isLast())dc+=20;
        }
        return dc;
    }
}
