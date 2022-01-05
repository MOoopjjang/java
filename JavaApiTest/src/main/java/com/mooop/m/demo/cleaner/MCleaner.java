package com.mooop.m.demo.cleaner;

import java.io.File;
import java.util.Arrays;

public class MCleaner {


    private static void run(String path , String[] target){

        File entry = new File(path);
        if(!entry.exists() || !entry.isDirectory())return;


        File[] fileList = entry.listFiles();
        for(File file : fileList){
            if(file.isDirectory()){
                run( file.getPath() , target );
            }else{
                int lastIndex = file.getName().lastIndexOf(".");
                if(lastIndex != -1){
                    String ext = file.getName().substring(lastIndex+1);
                    Arrays.asList(target).stream()
                        .filter(t->t.equals(ext))
                        .map(t->{
                            System.out.println("delete ->"+file.getPath());
                            file.delete();
                            return true;
                        }).count();
                }
            }
        }
    }

    private static boolean chk(String[] args){
        if(args == null || args.length < 2){
            return false;
        }

        File root = new File(args[0]);
        if(!root.exists() || !root.isDirectory()){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        if(chk(args)){
            String[] target = new String[args.length-1];
            for(int i = 1 , j = 0 ; i < args.length ; i++ , j++){
                target[j] = args[i];
            }
            System.out.println("path : "+args[0]);
            run(args[0] , target);
        }else{
            System.out.println("Usage : java -jar MClean.jar ");
        }
    }
}
