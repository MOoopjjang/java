package com.mooop.m.designpattern.movie;


import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 기간조건
 */
public class PeriodCondition implements DiscountCondition{
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;


    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
            && startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0
            && endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
