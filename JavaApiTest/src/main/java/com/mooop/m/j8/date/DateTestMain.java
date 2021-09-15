package com.mooop.m.j8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTestMain {
	
	
	
	private static void TimeZone_tst() throws Exception{
		
		ZonedDateTime z1 = ZonedDateTime.now();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(z1.toInstant(), ZoneOffset.UTC);
//		String strDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDateTime);
		System.out.println(localDateTime);

		
		ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
		ZonedDateTime utcTime = ZonedDateTime.now(seoulZoneId);
		ZonedDateTime utc = utcTime.withZoneSameInstant(ZoneOffset.UTC);
		System.out.println(utc);
		
	}
	
	
	private static void LocalDateTime_tst() throws Exception{
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime :"+localDateTime);
		
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("zdt :"+localDateTime);
	}
	
	
	private static void tst_1() throws Exception{
		LocalDate date = LocalDate.of(2019, 06, 12);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		boolean leap = date.isLeapYear();
		
		System.out.println("month :"+month.getValue());
		
		LocalDate today = LocalDate.now();
		System.out.println("now month : "+today.getMonthValue());
	}

	public static void main(String[] args) {
		
		try{
//			tst_1();
			
//			LocalDateTime_tst();
			
			TimeZone_tst();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
