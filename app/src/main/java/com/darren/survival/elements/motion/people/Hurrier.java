package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Motion;
import com.darren.survival.elements.model.Scene;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Hurrier extends Motion {
    int CALORIE = -300;
    int WATER = -9;
    int TEMPERATURE = -5;
    int VIGOR = -5;
    int TIME = -30;

    Scene scene = null;
    Firer firer = null;

    private static Hurrier hurrier = new Hurrier();

    public static Hurrier getInstance() {
        return hurrier;
    }

    private Hurrier() {
        super();
        scene = getSurvivor().getScene();
        firer = Firer.getInstance();
    }

    @Override
    public void act() {
       super.act();
        firer.setFireTimeLeft(-firer.getFireTimeLeft());
        scene.setLength(scene.getLength() - scene.getSpeed());
        if (scene.getLength() <= 0) {
            scene.setLength(20);
            getSurvivor().setScene(scene.getNext());
            scene = getSurvivor().getScene();
        }
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
