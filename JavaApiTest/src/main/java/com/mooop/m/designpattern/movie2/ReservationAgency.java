package com.mooop.m.designpattern.movie2;

import com.mooop.m.designpattern.movie.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening , Customer customer , int audienceCount){
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer , screening , fee , audienceCount);
    }

    /*
    public Reservation reserve(Screening screening , Customer customer , int audienceCount){
        Movie movie = screening.getMovie();

        boolean discountable = false;
        for(DiscountCondition discountCondition : movie.getDiscountConditions()){
            if(discountCondition.getType() == DiscountConditionType.PERIOD){
                discountable = screening.getWhenScreened().getDayOfWeek().equals(discountCondition.getDayOfWeek());
            }else{
                discountable = discountCondition.getSequence() == screening.getSequence();
            }

            if(discountable)break;
        }

        Money fee;
        if(discountable){
            Money discountAmount = Money.ZERO;
            switch(movie.getMovieType()){
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }
            fee = movie.getFee().minus(discountAmount);
        }else{
            fee = movie.getFee();
        }
        return new Reservation(customer , screening , fee , audienceCount);
    }

     */
}
