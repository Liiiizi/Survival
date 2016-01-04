package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.utls.RandomUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Hunter extends Motion {
    private List<Good> backpack = new ArrayList<>();

    public static int CALORIE = -300;
    public  static int WATER = -9;
    public static int TEMPERATURE = -5;
    public static int VIGOR = -5;
    public static int TIME = -30;

    private static Hunter ourInstance = new Hunter();

    public static Hunter getInstance() {
        return ourInstance;
    }

    private Hunter() {
        super();
        backpack = getSurvivor().getBackpack();
    }

    @Override
    public void act() {
       super.act();
        List<Good> goods = RandomUtil.randomGoods(getSurvivor().getScene(), this);
        for(Iterator<Good> it = goods.iterator(); it.hasNext();) {
            Good good = it.next();
            good.setCOUNT(good.getCOUNT() + 1);
            if(!backpack.contains(good)) backpack.add(good);
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
