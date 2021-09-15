package com.mooop.m.designpattern.proxy;

public class PrintProxy implements Printable{
    String name;
    Print real;

    public PrintProxy(String name){
      this.name = name;
    }

    @Override
    public void setPrintName(String printName) {
        if(real != null){
            real.setPrintName(printName);
        }
        this.name = printName;
    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print() {
        realize();
        real.print();
    }

    private synchronized void realize(){
        if(real == null){
            real = new Print();
        }
    }
}
