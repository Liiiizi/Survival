package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survival;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Packer implements Packable {
    private Survival protagonist = null;
    private static Packer packer = new Packer();

    public static Packer getInstance() {
        return packer;
    }

    private Packer() {
        protagonist = Survival.getInstance();
    }

    @Override
    public void pack() {
        protagonist.getCalorie().change(Packable.CALORIE);
        protagonist.getWater().change(Packable.WATER);
        protagonist.getTemperature().change(Packable.TEMPERATURE);
        protagonist.getVigor().change(Packable.VIGOR);
        protagonist.getTime().change(Packable.TIME);

    }
}
