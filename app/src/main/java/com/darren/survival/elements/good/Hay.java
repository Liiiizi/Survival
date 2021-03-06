package com.darren.survival.elements.good;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.motion.good.Fireable;

/**
 * Created by Darren on 2015/12/15 0015.
 */
public class Hay extends Good implements Fireable {
    public static final double WEIGHT = 0.05;
    public static final int FIRE_TIME = 10;
    public static int COUNT = 0;
    public static final String ID ="FR5";
    private static Hay ourInstance = new Hay();

    public static Hay getInstance() {
        return ourInstance;
    }

    private Hay() {
    }
    @Override
    public double getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public int getFireTime() {
        return FIRE_TIME;
    }

    @Override
    public int getCOUNT() {
        return COUNT;
    }

    @Override
    public void setCOUNT(int COUNT) {
        this.COUNT += COUNT;
    }

    @Override
    public String getID() {
        return ID;
    }
}
