package com.mooop.m.designpattern.fruit.v0;

import com.mooop.m.designpattern.fruit.vo.Fruit;

public class FrutiTestV0Main {


    public static void main(String[] args) {
        FruitShopV0 shop = new FruitShopV0();
        CustomerV0 customer1 = shop.enter();
        shop.goSaleStand(customer1
            , new Fruit("apple" , 1000L , Fruit.FRESH_STATUS.FRESH)
             , new Fruit("banana" , 1200L , Fruit.FRESH_STATUS.FRESH));


        CustomerV0 customer2 = shop.enter();
        shop.goSaleStand(customer2
             , new Fruit("banana" , 1200L , Fruit.FRESH_STATUS.FRESH));


        CustomerV0 customer3 = shop.enter();
        shop.goSaleStand(customer3
             , new Fruit("apple" , 1000L , Fruit.FRESH_STATUS.FRESH));


        CustomerV0 customer4 = shop.enter();
        shop.goSaleStand(customer4
             , new Fruit("apple" , 1000L , Fruit.FRESH_STATUS.FRESH)
             , new Fruit("apple" , 1000L , Fruit.FRESH_STATUS.NOTFRESH)
             , new Fruit("apple" , 1000L , Fruit.FRESH_STATUS.FRESH));
    }
}
