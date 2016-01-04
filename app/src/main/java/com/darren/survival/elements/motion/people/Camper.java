package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.model.Motion;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Camper extends Motion {
    private Survivor protagonist = null;

    public static int CALORIE = -300;
    public  static int WATER = -5;
    public static int TEMPERATURE = -5;
    public static int VIGOR = -5;
    public static int TIME = -30;

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
    public void act() {
       super.act();
        CAMPED = true;
    }

    public void camp() {

    }

    public static boolean isCAMPED() {
        return CAMPED;
    }

    public static void setCAMPED(boolean CAMPED) {
        Camper.CAMPED = CAMPED;
    }

    @Override
    public int getCALORIE() {
        return CALORIE;
    }

    @Override
    public int getWATER() {
        return WATER;
    }

    @Override
    public int getTEMPERATURE() {
        return TEMPERATURE;
    }

    @Override
    public int getVIGOR() {
        return VIGOR;
    }

    @Override
    public int getTIME() {
        return TIME;
    }
}
