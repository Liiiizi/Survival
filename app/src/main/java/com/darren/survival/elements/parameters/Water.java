package com.darren.survival.elements.parameters;

import com.darren.survival.elements.model.Parameter;

/**
 * Created by Darren on 2015/12/7 0007.
 */
public class Water extends Parameter {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private int value = 70;

    public static Water water = new Water();

    private Water() {

    }

    public static Water getInstance() {
        return water;
    }

    public void change(int value) {
        this.value += value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
