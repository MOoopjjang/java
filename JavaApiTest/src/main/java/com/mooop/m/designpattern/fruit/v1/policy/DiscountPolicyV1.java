package com.mooop.m.designpattern.fruit.v1.policy;

import com.mooop.m.designpattern.fruit.v1.CustomerV1;
import com.mooop.m.designpattern.fruit.v1.discount.CustomerDiscountV1;
import com.mooop.m.designpattern.fruit.v1.discount.EventDiscount;
import com.mooop.m.designpattern.fruit.v1.discount.FruitDiscountV1;
import com.mooop.m.designpattern.fruit.v1.discount.IDiscountConditionV1;
import com.mooop.m.designpattern.fruit.vo.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiscountPolicyV1 {
    private static final int MAX_CUSTOMER_COUNT = 4;

    private static final int EVENT_SEQ = new Random().nextInt(MAX_CUSTOMER_COUNT);

    public List<IDiscountConditionV1> createDiscountList(Fruit fruit , CustomerV1 customer){
        StringBuilder sb = new StringBuilder();
        List<IDiscountConditionV1> discountList = new ArrayList<>();

        if(MAX_CUSTOMER_COUNT == customer.getSeq())customer.changeLast();



        sb.append("customer discount :");
         if(customer.isFirst() || customer.isLast()){
             discountList.add(new CustomerDiscountV1(customer));
             sb.append("true");
         }

         sb.append("fruit discount :");
         if(fruit.isNotFresh()){
             discountList.add(new FruitDiscountV1(fruit));
             sb.append("true");
         }

         sb.append("event discount :");
         if(customer.getSeq() == EVENT_SEQ){
             discountList.add(new EventDiscount());
             sb.append("true");
         }

         System.out.println("discount==>"+sb.toString());
         return discountList;
    }
}
