package com.mooop.m.designpattern.fruit.v0;

public class CustomerV0 {
    int seq;
    CustomerStatusV0 status;
    public CustomerV0(){
         this.seq = 0;
        this.status = new CustomerStatusV0();
    }

    public CustomerV0(int seq){
         this.seq = seq;
        this.status = new CustomerStatusV0();
    }

    public CustomerV0(int seq , int maxCustomerCount){
        this.seq = seq;
        this.status = new CustomerStatusV0();
        this.status.setFirst(this.seq == 1);
        this.status.setLast(this.seq == maxCustomerCount);
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

    public boolean isFirstAndLast(){
        return status.isLastAndFirst();
    }
}
