package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survival;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Firer implements Fireable {
    private Survival protagonist = null;

    private static int FIRE_TIME_LEFT;

    private static Firer firer = new Firer();

    public static Firer getInstance() {
        return firer;
    }

    private Firer() {
        protagonist = Survival.getInstance();
        FIRE_TIME_LEFT = 0;
    }

    @Override
    public void fire() {
        protagonist.getCalorie().change(CALORIE);
        protagonist.getWater().change(WATER);
        protagonist.getTemperature().change(TEMPERATURE);
        protagonist.getVigor().change(VIGOR);
        protagonist.getTime().change(TIME);
        setFireTimeLeft(10);
    }

    @Override
    public void add() {

    }

    public int getFireTimeLeft() {
        return FIRE_TIME_LEFT;
    }

    @Override
    public void setFireTimeLeft(int change) {
        FIRE_TIME_LEFT = (FIRE_TIME_LEFT + change) > 0 ? (FIRE_TIME_LEFT + change) : 0;
    }

}
