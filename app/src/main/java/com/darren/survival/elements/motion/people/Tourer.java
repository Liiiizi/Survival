package com.darren.survival.elements.motion.people;


import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.model.Good;
import com.darren.survival.utls.RandomUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Tourer implements Tourable {
    private Survivor survivor = null;
    private List<Good> backpack = new ArrayList<>();

    private Camper camper = null;

    public static Tourer tourer = new Tourer();

    private Tourer() {
        survivor = Survivor.getInstance();
        camper = Camper.getInstance();
        backpack = survivor.getBackpack();
    }

    public static Tourer getInstance() {
        return tourer;
    }

    @Override
    public List<Good> tour() {
        camper.setCAMPED(false);
        survivor.getCalorie().change(CALORIE);
        survivor.getWater().change(WATER);
        survivor.getTemperature().change(TEMPERATURE);
        survivor.getVigor().change(VIGOR);
        survivor.getTime().change(TIME);
        List<Good> goods = RandomUtil.randomGoods(survivor.getScene(), this);
        for(Iterator<Good> it = goods.iterator(); it.hasNext();) {
            Good good = it.next();
            good.setCOUNT(good.getCOUNT() + 1);
            if(!backpack.contains(good)) backpack.add(good);
        }
        return goods;
    }
}
