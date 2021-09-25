package com.mooop.m.designpattern.movie;


/**
 * 순번조건
 */
public class SequenceCondition implements DiscountCondition{
    private int sequence;

    public SequenceCondition(int sequence){
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(this.sequence);
    }
}
