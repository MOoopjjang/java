package com.mooop.m.j8.adv;

public class MyWordCounter {

    private int counter;
    private boolean lastSpace;
    public MyWordCounter(int counter , boolean lastSpace){
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public MyWordCounter accumlate(Character c){
        if(Character.isWhitespace(c)){
            return lastSpace?this:new MyWordCounter(counter , true);
        }else{
            return lastSpace?new MyWordCounter(counter+1 , false):this;
        }
    }

    public MyWordCounter combine(MyWordCounter mwc){
        return new MyWordCounter(this.counter + mwc.counter , mwc.lastSpace);
    }

    public int getCounter(){
        return this.counter;
    }
}
