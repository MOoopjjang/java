package com.mooop.m.j8.doctest;


import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.UUID;

public class DocMain {

    private static void tst1() throws Exception{


//        System.out.println("=================== map ==================");
//        for(String key:data.keySet()){
//            System.out.println("key :"+key);
//        }


        String fullurl = String.join("","/lss" , "/dl/download");
        System.out.println(">>>>>"+fullurl);


        String uuid = UUID.randomUUID().toString().replace("-" , "");
        System.out.println("uuid :"+uuid);


    }

    public static void main(String[] args) {
        try{
            tst1();
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    class User{
        private String name;
        private String age;
    }
}
