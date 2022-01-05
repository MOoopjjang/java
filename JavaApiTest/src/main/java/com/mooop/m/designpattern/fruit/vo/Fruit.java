package com.mooop.m.designpattern.fruit.vo;

import static com.mooop.m.designpattern.fruit.vo.Fruit.FRESH_STATUS.NOTFRESH;

public class Fruit {
    private String kind;
    private long price;
    private FRESH_STATUS status;

    public Fruit(String kind, long price, FRESH_STATUS status) {
        this.kind = kind;
        this.price = price;
        this.status = status;
    }


    public String getKind() {
        return kind;
    }

    public long getPrice() {
        return price;
    }

    public boolean isNotFresh(){
        return this.status == NOTFRESH;
    }

    public static enum FRESH_STATUS{
        FRESH , NORMAL , NOTFRESH
    }
}
