package com.darren.survival.elements.scene;

import com.darren.survival.elements.model.Scene;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Road extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final String[] nextScene = {};
    public final int[] nextSceneWeight = {};
    //此场景类的名字
    public static final String Type = "Road";
    //此场景的下一场景是否可能为终点场景
    public static final String CanBEnd = "none";
    //此场景的最小及最大长度
    private static final int minLength = 0;
    private static final int maxLength = 0;
    //初始化此场景时随机长度
    private int length;
    //此场景的移动速度
    private int speed;
    //单例模式
    private static Road road = new Road();

    //单例模式
    private Road() {
        setLength(20);
        speed = 2;
    }

    //单例模式
    public static Road getInstance() {
        return road;
    }

    public String[] getNextScene() {
        return nextScene;
    }

    public int[] getNextSceneWeight() {
        return nextSceneWeight;
    }

    public String getCanBEnd() {
        return CanBEnd;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSpeed() {
        return speed;
    }
}
