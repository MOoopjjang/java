package com.mooop.m.j8.etc;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class TimeTest {
	
	
	
	private static void tst_5() throws Exception{
		
		ZonedDateTime korea = ZonedDateTime.of(2017, 12, 9, 14, 30,0,0, ZoneId.of("Asia/Seoul"));
		ZonedDateTime paris = ZonedDateTime.of(2017, 12, 9, 17, 25, 0, 0, ZoneId.of("Europe/Paris"));
		
		Duration diff = Duration.between(korea, paris);
		System.out.println("비행시간 : "+diff.toHours());
	}
	
	
	private static void tst_4() throws Exception{
		
		ZonedDateTime here = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Seoul"));
		
		System.out.println("here : "+here);
		
		ZonedDateTime paris = ZonedDateTime.of(here.toLocalDateTime(), ZoneId.of("Europe/Paris"));
		System.out.println("paris : "+paris);
		
		Duration diff = Duration.between(here, paris);
		System.out.println(diff.toHours());
		
		
	}
	
	//ZoneId에서 지원하는 지역들을 출력한다.
	private static void zoneId_tst() throws Exception{
		
		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
	}
	
	
	//LocalDateTime 
	private static void tst_3() throws Exception{
		
		LocalDateTime today = LocalDateTime.now();
		
		//항공1편
		LocalDateTime flight1 = LocalDateTime.of(2020, 4, 25, 11, 20);
		//항공2편
		LocalDateTime flight2 = LocalDateTime.of(2020, 5, 14, 11, 15);
		
		LocalDateTime myFlight = null;
		if(flight1.isBefore(flight2)) {
			myFlight = flight1;
		}else {
			myFlight = flight2;
		}
		
		//날짜 계산
		Period day = Period.between(today.toLocalDate(), myFlight.toLocalDate());
		
		Duration time = Duration.between(today.toLocalTime(), myFlight.toLocalTime());
		
		System.out.println("남은 날짜 : "+day.getDays());
		System.out.println("남은 시간 : "+time.toHours());
	}
	
	//LocalDate ( 시각 정보가 빠진 날짜정보 )
	//LocalTime ( 날짜 정보가 빠진 시각정보 )
	private static void tst_2() throws Exception{
		
		LocalDate today = LocalDate.now();
		System.out.println("today : "+today);
		
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println(xmas);
		
		LocalDate xmase = xmas.minusDays(1);
		System.out.println(xmase);
		
		
		/**
		 * 오늘부터 크리스마까지의 기간 측정
		 */
		Period left = Period.between(today, xmas);
		System.out.println(left.getMonths()+" 월 "+left.getDays()+" 일");
		
		
		LocalTime ti = LocalTime.now();
		System.out.println("지금 시각 :"+ti);
		
		LocalTime ta = ti.plusHours(2);
		System.out.println("지금으로부터 "+ta+" 후에 회의를 진행합니다.");
		
		LocalTime end = LocalTime.of(17, 20 , 30);
		System.out.println("PC방 남은시간은 : "+Duration.between(ti, end).toHours());
		
	}
	
	
	private static long fibonacci(long n) {
		if(n == 1 || n ==2) {
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n - 2);
	}
	
	//parallel stream
	private static void tst_parallel() throws Exception{
		List<Integer> nums = Arrays.asList(10,20,31,12,13);
		
		Instant start = Instant.now();
		nums.parallelStream().map(n->fibonacci(n))
		.forEach(System.out::println);
		
		Instant end = Instant.now();
		System.out.println("Duration Processing ::"+Duration.between(start, end).toMillis());
	}
	
	//stream
	private static void tst_stream() throws Exception{
		List<Integer> nums = Arrays.asList(10,20,31,12,13);
		
		Instant start = Instant.now();
		nums.stream().map(n->fibonacci(n))
		.forEach(System.out::println);
		
		
		Instant end = Instant.now();
		System.out.println("Duration Processing ::"+Duration.between(start, end).toMillis());
		
	}
	
	private static void tst_1() throws Exception{
		
		Instant start = Instant.now();
		System.out.println("시작 : "+start.getEpochSecond());
		
		System.out.println("Time files like an arrow.");
		
		Thread.sleep(2000L);
		
		Instant end = Instant.now();
		System.out.println("끝 : "+end.getEpochSecond());
		
		Duration between = Duration.between(start, end);
		System.out.println("밀리초 단위 차 : "+between.toMillis());
	}
	
	public static void main(String[] args) {
		
		try {
//			tst_1();
			
//			tst_stream();
			
//			tst_parallel();
			
//			tst_2();
			
//			tst_3();
			
//			zoneId_tst();
			
//			tst_4();
			
			tst_5();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
