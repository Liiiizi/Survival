package com.darren.survival.elements;

import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;
import com.darren.survival.elements.motion.people.Camper;
import com.darren.survival.elements.motion.people.Collector;
import com.darren.survival.elements.motion.people.Firer;
import com.darren.survival.elements.motion.people.Hunter;
import com.darren.survival.elements.motion.people.Hurrier;
import com.darren.survival.elements.motion.people.Maker;
import com.darren.survival.elements.motion.people.Packer;
import com.darren.survival.elements.motion.people.Restor;
import com.darren.survival.elements.motion.people.Tourer;
import com.darren.survival.elements.parameters.Calorie;
import com.darren.survival.elements.parameters.Temperature;
import com.darren.survival.elements.parameters.Time;
import com.darren.survival.elements.parameters.Vigor;
import com.darren.survival.elements.parameters.Water;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2015/12/7 0007.
 * fire部分待修正
 */
public class Survivor {
    private Calorie calorie = null;
    private Water water = null;
    private Temperature temperature = null;
    private Vigor vigor = null;
    private Time time = null;

    private Camper camper = null;
    private Collector collector = null;
    private Firer firer = null;
    private Hunter hunter = null;
    private Hurrier hurrier =null;
    private Maker maker = null;
    private Packer packer = null;
    private Restor restor = null;
    private Tourer tourer = null;

    private Scene scene = null;

    private List<Good> backpack = new ArrayList<>();


    private static Survivor protagonist = new Survivor();

    private Survivor() {
        //初始化场景，生成第一个场景
        scene = new Scene();
        scene = scene.getNext();

    }

    public void init() {
        //得到各属性类的实例
        calorie = Calorie.getInstance();
        water = water.getInstance();
        temperature = Temperature.getInstance();
        vigor = Vigor.getInstance();
        time =Time.getInstance();
        //得到各行为类的实例
        camper = Camper.getInstance();
        collector = Collector.getInstance();
        firer = Firer.getInstance();
        hunter = Hunter.getInstance();
        hurrier = Hurrier.getInstance();
        maker = Maker.getInstance();
        packer = Packer.getInstance();
        restor = Restor.getInstance();
        tourer = Tourer.getInstance();
    }

    public static Survivor getInstance() {
        return protagonist;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Calorie getCalorie() {
        return calorie;
    }

    public Water getWater() {
        return water;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Vigor getVigor() {
        return vigor;
    }

    public Time getTime() {
        return time;
    }

    public Camper getCamper() {
        return camper;
    }

    public Collector getCollector() {
        return collector;
    }

    public Firer getFirer() {
        return firer;
    }

    public Hunter getHunter() {
        return hunter;
    }

    public Hurrier getHurrier() {
        return hurrier;
    }

    public Maker getMaker() {
        return maker;
    }

    public Packer getPacker() {
        return packer;
    }

    public Restor getRestor() {
        return restor;
    }

    public Tourer getTourer() {
        return tourer;
    }

    public List<Good> getBackpack() {
        return backpack;
    }
}
