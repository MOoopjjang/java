package com.mooop.m.designpattern.fruit.v0;

import com.mooop.m.designpattern.fruit.vo.Fruit;
import com.mooop.m.designpattern.fruit.vo.SeqDev;

/**
 *  과일판매숍
 */
public class FruitShopV0 {
    private FruitSellerV0 seller;
    private DiscountV0 discount;
    private SeqDev seqDev;
//    private List<Fruit> fruits;


    public FruitShopV0(){
        open();
    }


    /**
     * 과일가계에 들어온다.
     *
     * @return
     */
    public CustomerV0 enter(){
        CustomerV0 customer = new CustomerV0();
        customer.setSeq(seqDev);
        return customer;
    }


    /**
     * 판매대에서 계산한다.
     *
     * @param customer
     */
    public void goSaleStand(CustomerV0 customer , Fruit... fruits){
        seller.sellTo(customer , fruits);
    }



    private void open(){
        this.discount = new DiscountV0();
        this.seller = new FruitSellerV0(discount);
        this.seqDev = new SeqDev();
    }

}
