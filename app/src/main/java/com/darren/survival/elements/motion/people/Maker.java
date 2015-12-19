package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survivor;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Maker implements Makable {
    private Survivor protagonist = null;

    private static Maker ourInstance = new Maker();

    public static Maker getInstance() {
        return ourInstance;
    }

    private Maker() {
        protagonist = Survivor.getInstance();
    }

    @Override
    public void make() {
        protagonist.getCalorie().change(Maker.CALORIE);
        protagonist.getWater().change(Maker.WATER);
        protagonist.getTemperature().change(Maker.TEMPERATURE);
        protagonist.getVigor().change(Maker.VIGOR);
        protagonist.getTime().change(Maker.TIME);
    }
}
