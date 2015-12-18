package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Motion;

/**
 * Created by Darren on 2015/12/7 0007.
 */
public interface Campable extends Motion {
    //how many value will change for every parameters
    public static int CALORIE = -300;
    public  static int WATER = -5;
    public static int TEMPERATURE = -5;
    public static int VIGOR = -5;
    public static int TIME = -30;

    void camp();
}
