package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survival;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Hunter implements Hurryable {
    private Survival protagonist = null;

    private static Hunter ourInstance = new Hunter();

    public static Hunter getInstance() {
        return ourInstance;
    }

    private Hunter() {
        protagonist = Survival.getInstance();

    }

    @Override
    public void hurry() {
        protagonist.getCalorie().change(CALORIE);
        protagonist.getWater().change(WATER);
        protagonist.getTemperature().change(TEMPERATURE);
        protagonist.getVigor().change(VIGOR);
        protagonist.getTime().change(TIME);
    }
}
