package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.Survival;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/11 0011.
 */
public class Collector implements Collectable {
    private Survival protagonist = null;

    private Map<Scene,HashMap<Good,Integer>> goods =new HashMap<Scene,HashMap<Good,Integer>>();
    private static Collector collector = new Collector();

    public static Collector getInstance() {
        return collector;
    }

    private Collector() {
        protagonist = Survival.getInstance();
    }

    @Override
    public void collect() {

    }

}
