package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survivor;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Camper implements Campable {
    private Survivor protagonist = null;

    private static boolean CAMPED = false;


    private static Camper ourInstance = new Camper();

    public static Camper getInstance() {
        return ourInstance;
    }

    private Camper() {
        protagonist = Survivor.getInstance();
        CAMPED = false;
    }

    @Override
    public void camp() {
        protagonist.getCalorie().change(CALORIE);
        protagonist.getWater().change(WATER);
        protagonist.getTemperature().change(TEMPERATURE);
        protagonist.getVigor().change(VIGOR);
        protagonist.getTime().change(TIME);
        CAMPED = true;
    }

    public static boolean isCAMPED() {
        return CAMPED;
    }

    public static void setCAMPED(boolean CAMPED) {
        Camper.CAMPED = CAMPED;
    }

}
