package com.mooop.m.j8.thd;



class WorkObject{
    public synchronized void methodA(){
        System.out.println("methodA 실행");
        notify(); // 일시정지 상태에 있는 ThreadB를 실행 대기상태로 만듬
        try{
            wait(); // ThreadA를 일시 정지 상태로 만듬
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


class Thd1 extends Thread{

    public Thd1(){

    }
    @Override
    public void run() {
        synchronized (this){
            try{
                System.out.println(">>> Thd1 WAIT <<<");
                wait();
                for(int i = 0 ; i < 10 ; i++){
                    System.out.println("Thd1 count : "+i);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Thd2 extends Thread{


    @Override
    public void run() {
        synchronized (this){
            try{
                System.out.println(">>> Thd2 WAIT <<<");
                wait();
                for(int i = 0 ; i < 10 ; i++){
                    System.out.println("Thd1 count : "+i);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}


public class ThdMain1 {

    public static void main(String[] args) {

        Thd1 t1 = new Thd1();
        Thd2 t2 = new Thd2();

        t1.start();
        t2.start();

        synchronized (t1){
            t1.notify();
        }

    }
}
