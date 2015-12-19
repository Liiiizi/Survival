package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.model.Scene;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Hurrier implements Hurryable {
    private Survivor protagonist = null;
    Scene scene = null;
    Firer firer = null;

    private static Hurrier hurrier = new Hurrier();

    public static Hurrier getInstance() {
        return hurrier;
    }

    private Hurrier() {
        protagonist = Survivor.getInstance();
        scene = protagonist.getScene();
        firer = Firer.getInstance();
    }

    @Override
    public void hurry() {
        protagonist.getCalorie().change(CALORIE);
        protagonist.getWater().change(WATER);
        protagonist.getTemperature().change(TEMPERATURE);
        protagonist.getVigor().change(VIGOR);
        protagonist.getTime().change(TIME);
        firer.setFireTimeLeft(-firer.getFireTimeLeft());
        scene.setLength(scene.getLength() - scene.getSpeed());
        if (scene.getLength() <= 0) {
            scene.setLength(20);
            protagonist.setScene(scene.getNext());
            scene = protagonist.getScene();
        }
    }
}
