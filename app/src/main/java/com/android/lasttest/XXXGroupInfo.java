package com.android.lasttest;

import java.util.ArrayList;

/**
 * Created by batsa on 26.07.2017.
 */

public class XXXGroupInfo {

    private ArrayList<XXXChildInfo> childList = new ArrayList<XXXChildInfo>();

    private String nameofPair;
    private String directionOfPair;
    private double valueOfPair;
    private String openClosePrice;
    private double rightValue;

    public ArrayList<XXXChildInfo> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<XXXChildInfo> childList) {
        this.childList = childList;
    }

    public String getNameofPair() {
        return nameofPair;
    }

    public void setNameofPair(String nameofPair) {
        this.nameofPair = nameofPair;
    }

    public String getDirectionOfPair() {
        return directionOfPair;
    }

    public void setDirectionOfPair(String directionOfPair) {
        this.directionOfPair = directionOfPair;
    }

    public double getValueOfPair() {
        return valueOfPair;
    }

    public void setValueOfPair(double valueOfPair) {
        this.valueOfPair = valueOfPair;
    }

    public String getOpenClosePrice() {
        return openClosePrice;
    }

    public void setOpenClosePrice(String openClosePrice) {
        this.openClosePrice = openClosePrice;
    }

    public double getRightValue() {
        return rightValue;
    }

    public void setRightValue(double rightValue) {
        this.rightValue = rightValue;
    }
}
