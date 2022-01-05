package com.mooop.m.designpattern.fruit.v1;

import com.mooop.m.designpattern.fruit.vo.Fruit;

public class FruitTestV1 {

    public static void main(String[] args) {

        FruitShopV1 shop = new FruitShopV1();

        Fruit fruit1 = new Fruit("apple" , 3200 , Fruit.FRESH_STATUS.FRESH);
        shop.buy(fruit1);

        fruit1 = new Fruit("banana" , 2000 , Fruit.FRESH_STATUS.NORMAL);
        shop.buy(fruit1);

        fruit1 =new Fruit("banan2a" , 2000 , Fruit.FRESH_STATUS.NOTFRESH);
        shop.buy(fruit1);

        fruit1 = new Fruit("apple2" , 3200 , Fruit.FRESH_STATUS.NOTFRESH);
        shop.buy(fruit1);
    }
}
