package com.mooop.m.j8.net;

import java.util.ArrayList;
import java.util.List;

/**
 *   IPV4 의 ip 대역 및 ip 지정을 List로 반환.
 */
public class MIpParsing {


    private static void splitRangeIp(String preIp , int curIndex , int endIndex ,String[] org ,  List<String> list){
        if(org[curIndex].indexOf('~') > 0){
            String[] sub = org[curIndex].split("~");
            int nStart = Integer.parseInt(sub[0]);
            int nEnd = Integer.parseInt(sub[1]);
            System.out.println("curIndex>>" +curIndex+" ,nStart >> "+nStart+" , nEnd >> "+nEnd);

            while(nStart <= nEnd){
                String tmpIp = String.join("." , preIp , ""+nStart);
                if(curIndex == (endIndex - 1)){
                    System.out.println("tmpIp >> "+tmpIp);
                    list.add(tmpIp);
                }else{
                    splitRangeIp(tmpIp , curIndex+1 , endIndex , org , list);
                }
                nStart++;
            }
        }else{
            preIp += (preIp.equals("")?org[curIndex]:"."+org[curIndex]);
            System.out.println("preIp >>"+preIp);
            if(curIndex == (endIndex - 1)){
                list.add(preIp);
            }else{
                splitRangeIp(preIp , curIndex+1 , endIndex , org , list);
            }
        }
    }


    private static List<String> ipRangeStringArray(String ipAddress){
        String[] ss = ipAddress.split("\\.");
        if(ss.length != 4){
            throw new RuntimeException("입력값 오류.");
        }

        List<String> ipList = new ArrayList<>();
        splitRangeIp("" , 0 , ss.length , ss , ipList);
        return ipList;
    }

    public static void main(String[] args) {
//        List<String> resultList = ipRangeStringArray("192.168.0.11");
//        resultList.stream().forEach(System.out::println);

        List<String>  resultList = ipRangeStringArray("192.168.4.3~10");
        System.out.println("=============================================");
        resultList.stream().forEach(System.out::println);
    }
}
