package com.darren.survival.elements.scene;

import com.darren.survival.elements.model.Scene;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class River extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public static final String[] nextScene = {"Forest", "Plains", "Jungle", "Lake"};
    public static final int[] nextSceneWeight = {1, 1, 1, 1};
    //此场景类的名字
    public static final String Type = "River";
    //此场景的下一场景是否可能为终点场景
    public final String CanBEnd = "both";

    //此场景的最小及最大长度
    private final int minLength = 10;
    private final int maxLength = 20;
    //初始化此场景时随机长度
    private int length;
    //此场景的移动速度
    private int speed;
    //单例模式
    private static River river = new River();

    //单例模式
    private River() {
        setLength(20);
        speed = 2;
    }

    //单例模式
    public static River getInstance() {
        return river;
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
