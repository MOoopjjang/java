package com.mooop.m.designpattern.fruit.vo;

public class SeqDev {
    private int seq;

    public SeqDev(){
        this.seq = 0;
    }

    /**
     * 방문순서를 반환한다.
     *
     * @return
     */
    public int createSeq(){
        return nextSeq();
    }

    private int nextSeq(){
        this.seq++;
        System.out.println(">>>발급된 순번 : "+this.seq);
        return this.seq;
    }
}
