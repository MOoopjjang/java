package com.mooop.m.designpattern.proxy;

public class Print implements Printable{
    private String name;


    public Print(){
        heavyJob();
    }

    @Override
    public void setPrintName(String printName) {
        this.name = printName;
    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("===== name : "+this.name+" =========");
    }

    private void heavyJob(){
        try{

            for(int i = 0 ; i < 5 ; i++){
                Thread.sleep(1000L);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("heavyJob 완료");
    }
}
