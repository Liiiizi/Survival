package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survival;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Restor implements Restable {
    private Survival protagonist = null;

    public static Restor restor = new Restor();

    private Restor() {
        protagonist = Survival.getInstance();
    }

    public static Restor getInstance() {
        return restor;
    }
    @Override
    public void rest() {
        protagonist.getCalorie().change(Restable.CALORIE);
        protagonist.getWater().change(Restable.WATER);
        protagonist.getTemperature().change(Restable.TEMPERATURE);
        protagonist.getVigor().change(Restable.VIGOR);
        protagonist.getTime().change(Restable.TIME);
    }
}
