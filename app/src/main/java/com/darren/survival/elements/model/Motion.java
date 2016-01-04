package com.darren.survival.elements.model;

import com.darren.survival.elements.Survivor;

/**
 * Created by Darren on 2015/12/5 0005.
 */
public class Motion {
    private Survivor survivor = null;

    public Motion() {
        survivor = Survivor.getInstance();
    }

    public void act() {
        survivor.getCalorie().change(getCALORIE());
        survivor.getWater().change(getWATER());
        survivor.getTemperature().change(getTEMPERATURE());
        survivor.getVigor().change(getVIGOR());
        survivor.getTime().change(getTIME());
    }

    public Survivor getSurvivor() {
        return survivor;
    }

    public int getCALORIE() {
        return 0;
    }

    public int getWATER() {
        return 0;
    }

    public int getTEMPERATURE() {
        return 0;
    }

    public int getVIGOR() {
        return 0;
    }

    public int getTIME() {
        return 0;
    }
}
