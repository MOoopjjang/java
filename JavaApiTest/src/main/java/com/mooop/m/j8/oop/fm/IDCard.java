package com.mooop.m.j8.oop.fm;

public class IDCard extends Product{
    String owner;
    public IDCard(String owner){
        this.owner = owner;
    }
    @Override
    public void use() {
        System.out.println(owner+" 의 카드를 사용합니다.");
    }

    public String getOwner(){
        return owner;
    }
}
