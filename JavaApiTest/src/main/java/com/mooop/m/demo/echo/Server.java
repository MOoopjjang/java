package com.mooop.m.demo.echo;

import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        Socket socket = null;

        try{
            socket = new Socket("localhost" , 3000);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
