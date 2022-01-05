package com.mooop.m.designpattern.fruit.v1;

public class CustomerV1 {
    private int seq;
    private CustomerStatusV1 status;

    public CustomerV1(int seq ){
        this.seq = seq;
        this.status = new CustomerStatusV1();
        this.status.setFirst(this.seq == 1);
        this.status.setLast(false);
    }

    public int getSeq() {
        return seq;
    }

    public boolean isFirst() {
        return status.isFirst();
    }

    public boolean isLast(){
        return status.isLast();
    }

    public void changeLast(){
        status.setLast(true);
    }

    public boolean isFirstAndLast(){
        return status.isLastAndFirst();
    }
}
