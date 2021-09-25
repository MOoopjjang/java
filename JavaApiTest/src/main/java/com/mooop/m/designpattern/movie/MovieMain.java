package com.mooop.m.designpattern.movie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;


/**
 * 할인 정책과 알인 조건이 지정된 영화
 *
 * ------------------------------------------------------------------------------------
 * 영화                   할인 정책                   할인조건
 * ------------------------------------------------------------------------------------
 * 아바타                 금액 할인 정책                순번조건
 * (가격 10,000원)         (할인액 : 800원 )           조조상영
 *                                              ---------------------------------------
 *                                                 순번조건
 *                                                 10회상영
 *                                              ---------------------------------------
 *                                                 기간조건
 *                                                 월요일 10:00 ~  12:00 사이 상영 시작
 *                                              ---------------------------------------
 *                                                 기간조건
 *                                                 목요일 18:00 ~ 21:00 사이 상영시작
 * =====================================================================================
 * 타이타닉               비율 할인 정책                  기간조건
 * (가격: 11,000원)       (할인율 : 10% )             화요일 14:00 ~ 17:00  사이 상영시작
 *                                              ---------------------------------------
 *                                                  순번조건
 *                                                  2회 상영
 *                                              ---------------------------------------
 *                                                  기간조건
 *                                                  목요일 10:00 ~ 14:00 사이 상영 시작
 * =====================================================================================
 *  스타워즈:깨어난 포스
 *  (가격:10,000 원)                   없음              없음
 * =====================================================================================
 */
public class MovieMain {

    public static void main(String[] args) {

        // 아바타...
        Movie avatar = new Movie("아바타", Duration.ofMinutes(1120)
            ,Money.wons(10000)
            , new AmountDiscountPolicy(Money.wons(800)
              , new SequenceCondition(1)
                , new SequenceCondition(10)
                ,new PeriodCondition(DayOfWeek.MONDAY , LocalTime.of(10 , 0) , LocalTime.of(11,59))
                ,new PeriodCondition(DayOfWeek.THURSDAY , LocalTime.of(10 , 0) , LocalTime.of(20 , 59))
            )
        );

        //타이타닉...
        Movie titanic = new Movie("타이타닉" , Duration.ofMinutes(180)
            ,Money.wons(10000)
            ,new PercentDiscountPolicy(0.1
                ,new PeriodCondition(DayOfWeek.TUESDAY , LocalTime.of(14,0) , LocalTime.of(16,59))
                ,new SequenceCondition(2)
                ,new PeriodCondition(DayOfWeek.THURSDAY , LocalTime.of(10 , 0) , LocalTime.of(13 , 59))
            )

        );


        //스타워즈...
        Movie starWars = new Movie("스타워즈" , Duration.ofMinutes(210)
            ,Money.wons(10000)
            ,new NonDiscountPolicy()
        );
    }
}
