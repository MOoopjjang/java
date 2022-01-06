package com.mooop.m.designpattern.fruit.v0;

import com.mooop.m.designpattern.fruit.vo.Bag;
import com.mooop.m.designpattern.fruit.vo.Fruit;
import com.mooop.m.designpattern.fruit.vo.SeqDev;

/**
 * 고객
 */
public class CustomerV0 {

    private Bag bag;


    public CustomerV0(){
        this.bag = new Bag();
    }



    /**
     * 과일을 담는다..
     * @param fruits
     */
    public void receiveFruits(Fruit... fruits){
        bag.addFruits(fruits);
    }


    /**
     * 과일값을 계산한다.
     *
     * @param reqAmount
     * @return
     */
    public long calculateFruit(long reqAmount){
        return bag.hold(reqAmount);
    }

    /**
     * 입장순서를 발급받는다.
     *
     * @param seqDev
     */
    public void setSeq(SeqDev seqDev){
        bag.setSeq(seqDev.createSeq());
    }


    /**
     * 입장순서를 보여준다.
     *
     * @return
     */
    public int getSeq(){
        return bag.getSeq();
    }
}
