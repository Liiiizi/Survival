package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Huntable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class FIshingRod extends Good implements Huntable {
    public static final double WEIGHT = 2;
    public static int COUNT = 0;
    private static FIshingRod fIshingRod = new FIshingRod();

    public static FIshingRod getInstance() {
        return fIshingRod;
    }

    private FIshingRod() {
    }

    @Override
    public double getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public int getCOUNT() {
        return COUNT;
    }

    @Override
    public void setCOUNT(int COUNT) {
        FIshingRod.COUNT = COUNT;
    }
}
