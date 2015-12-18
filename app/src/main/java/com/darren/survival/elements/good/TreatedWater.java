package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Makable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class TreatedWater extends Good implements Makable {
    public static final double WEIGHT = 0.5;
    public static int COUNT = 0;
    private static TreatedWater treatedWater = new TreatedWater();

    public static TreatedWater getInstance() {
        return treatedWater;
    }

    private TreatedWater() {
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
        TreatedWater.COUNT = COUNT;
    }
}
