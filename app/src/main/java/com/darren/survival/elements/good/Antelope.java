package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Antelope extends Good implements Makable {
    public static final double WEIGHT = 20;
    public static int COUNT = 0;
    private static Antelope antelope = new Antelope();

    public static Antelope getInstance() {
        return antelope;
    }

    private Antelope() {
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
        Antelope.COUNT = COUNT;
    }
}
