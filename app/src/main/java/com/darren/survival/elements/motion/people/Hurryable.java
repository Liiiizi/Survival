package com.darren.survival.elements.motion.people;

import com.darren.survival.elements.model.Motion;

/**
 * Created by Darren on 2015/12/7 0007.
 */
public interface Hurryable extends Motion {
    //how many value will change for every parameters
     int CALORIE = -300;
     int WATER = -9;
     int TEMPERATURE = -5;
     int VIGOR = -5;
     int TIME = -30;

    public void hurry();
}
