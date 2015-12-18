package com.darren.survival.elements.motion.people;


import com.darren.survival.elements.Survival;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Tourer implements Tourable {
    private Survival protagonist = null;

    private Camper camper = null;

    public static Tourer tourer = new Tourer();

    private Tourer() {
        protagonist = Survival.getInstance();
        camper = Camper.getInstance();
    }

    public static Tourer getInstance() {
        return tourer;
    }

    @Override
    public void tour() {
        camper.setCAMPED(false);
        protagonist.getCalorie().change(CALORIE);
        protagonist.getWater().change(WATER);
        protagonist.getTemperature().change(TEMPERATURE);
        protagonist.getVigor().change(VIGOR);
        protagonist.getTime().change(TIME);
    }
}
