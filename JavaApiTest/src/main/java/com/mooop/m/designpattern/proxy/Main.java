package com.mooop.m.designpattern.proxy;

public class Main {

    public static void main(String[] args) {
        Printable p = new PrintProxy("xferlog");
        System.out.println("현재 이름은 "+p.getPrintName()+" 입니다.");
        p.setPrintName("ejkim");
        System.out.println("변경된 이름은 "+p.getPrintName()+" 입니다.");
        p.print();
    }
}
