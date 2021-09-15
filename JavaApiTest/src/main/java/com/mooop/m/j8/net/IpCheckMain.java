package com.mooop.m.j8.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpCheckMain {
	
	private static int nMaskBits;
	private static InetAddress requiredAddress;
	
	
	
	private static InetAddress parseAddress(String address) {
		try {
			return InetAddress.getByName(address);
		}catch(UnknownHostException var3) {
			throw new IllegalArgumentException("Failed to parse address" + address, var3);
		}
	}
	
	
	private static void IpAddressMatcher(String ipAddress) {
		
		if(ipAddress.indexOf(47) > 0) {
			String[] ss = ipAddress.split("/");
			ipAddress = ss[0];
			nMaskBits = Integer.parseInt(ss[1]);
		}else {
			nMaskBits = -1;
		}
		
		requiredAddress = parseAddress(ipAddress);
	}
	
	
	
	private static boolean matches(String address) {
		InetAddress remoteAddress = parseAddress(address);
		
		byte[] remAddr = remoteAddress.getAddress();
		byte[] reqAddr = requiredAddress.getAddress();
		
		for(int i = 0 ; i < remAddr.length ; i++) {
			System.out.println("remAddr["+i+"] : "+remAddr[i]);
		}
		
		System.out.println("===============================================");
		
		for(int i = 0 ; i < reqAddr.length ; i++) {
			System.out.println("reqAddr["+i+"] : "+reqAddr[i]);
		}
		System.out.println("===============================================");
		
		
		int nMaskFullBytes = nMaskBits / 8;
		
		byte finalByte = (byte)('\uff00' >> (nMaskBits & 7));
		
		System.out.println("nMaskFullBytes :: "+nMaskFullBytes);
		System.out.println("(nMaskBits & 7) :: "+(nMaskBits & 7));
		System.out.println("finalByte :: "+finalByte);
		
		for(int i = 0 ; i < nMaskFullBytes ; ++i) {
			System.out.println("i : "+i);
			if(remAddr[i]!=reqAddr[i]) {
				return false;
			}
		}
		
		if(finalByte != 0) {
			return (remAddr[nMaskFullBytes] & finalByte) == (reqAddr[nMaskFullBytes] & finalByte);
		}else {
			return true;
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		IpAddressMatcher("192.168.0.0/24");
		matches("0:0:0:0:0:0:0:1");
		
	}

}
