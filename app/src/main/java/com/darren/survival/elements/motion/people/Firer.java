package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.good.Branch;
import com.darren.survival.elements.good.Hay;
import com.darren.survival.elements.good.Kindling;
import com.darren.survival.elements.good.Sawdust;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.elements.motion.good.Fireable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Firer extends Motion {
    private Survivor survivor = null;

    public static int CALORIE = -300;
    public  static int WATER = -9;
    public static int TEMPERATURE = -5;
    public static int VIGOR = -5;
    public static int TIME = -30;

    private static int FIRE_TIME_LEFT;

    private List<Good> KINDLINGS = new ArrayList<>();//火种
    private List<Good> INFLAMMABLE = new ArrayList<>();//易燃物

    private List<Good> fireables = new ArrayList<>();//可燃物，添加燃料时使用

    private static Firer firer = new Firer();

    public static Firer getInstance() {
        return firer;
    }

    private Firer() {
        survivor = Survivor.getInstance();
        FIRE_TIME_LEFT = 0;

        KINDLINGS.add(Branch.getInstance());
        KINDLINGS.add(Kindling.getInstance());
        INFLAMMABLE.add(Sawdust.getInstance());
        INFLAMMABLE.add(Hay.getInstance());
    }

    @Override
    public void act() {
       super.act();
    }

    public boolean fire(Good fireable) {
        act();
        fireable.setCOUNT(-1);
        setFireTimeLeft(((Fireable)fireable).getFireTime());
        return true;
    }

    public boolean startFire(Good kindling, Good inflammable) {
        kindling.setCOUNT(-1);
        inflammable.setCOUNT(-1);
        setFireTimeLeft(((Fireable)kindling).getFireTime());
        return true;
    }

    public int getFireTimeLeft() {
        return FIRE_TIME_LEFT;
    }

    public void setFireTimeLeft(int change) {
        FIRE_TIME_LEFT = (FIRE_TIME_LEFT + change) > 0 ? (FIRE_TIME_LEFT + change) : 0;
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

    public List<Good> getKINDLINGS() {
        return KINDLINGS;
    }

    public List<Good> getINFLAMMABLE() {
        return INFLAMMABLE;
    }

    public List<Good> getFireables() {
        fireables.clear();
        for(Good good : survivor.getBackpack()) {
            if(good instanceof Fireable) fireables.add(good);
        }
        return fireables;
    }
}
