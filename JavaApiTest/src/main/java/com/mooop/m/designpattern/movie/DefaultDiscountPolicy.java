package com.mooop.m.designpattern.movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy{

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition... v){
        this.conditions = Arrays.asList(v);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening){
        for(DiscountCondition d : conditions){
            if(d.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
