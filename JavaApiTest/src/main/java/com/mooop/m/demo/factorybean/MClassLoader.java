package com.mooop.m.demo.factorybean;

import java.io.*;

public class MClassLoader extends ClassLoader{

    @Override
    public Class<?> findClass(String fileFullPath) throws ClassNotFoundException {
        byte[] buffer = loadClassFromFile(fileFullPath);
        return defineClass(null , buffer , 0 , buffer.length);
    }


    private byte[] loadClassFromFile(String fileFullPath){
        byte[] buffer = null;
        ByteArrayOutputStream baos = null;
        try{
            FileInputStream fis = new FileInputStream(fileFullPath);
            baos = new ByteArrayOutputStream();
            int c;
            while((c = fis.read()) != -1){
                baos.write(c);
            }
            buffer =  baos.toByteArray();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                 if(baos != null){
                baos.close();
                baos = null;
            }
            }catch(Exception e){
            }

        }


        return buffer;
    }
}
