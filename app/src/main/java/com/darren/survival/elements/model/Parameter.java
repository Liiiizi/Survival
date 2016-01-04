package com.darren.survival.elements.model;

/**
 * Created by Darren on 2015/12/5 0005.
 */
public class Parameter {

    public void change(int value) {
    }

    public String getName() {
        String[] strTemp = getClass().getName().toString().split("\\.");
        String strName = strTemp[strTemp.length - 1];
        return strName;
    }

    public int getValue() {
        return 0;
    }

}
