package com.mooop.m.designpattern.fruit.v1;

public class CustomerStatusV1 {
    private boolean isFirst = false;
    private boolean isLast = false;

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isLastAndFirst(){
        return (isFirst == true && isLast == true);
    }
}
