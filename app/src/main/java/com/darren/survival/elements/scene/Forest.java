package com.darren.survival.elements.scene;

import com.darren.survival.elements.good.Branch;
import com.darren.survival.elements.good.Bug;
import com.darren.survival.elements.good.Cirrus;
import com.darren.survival.elements.good.Firewood;
import com.darren.survival.elements.good.Lighter;
import com.darren.survival.elements.good.Rabbit;
import com.darren.survival.elements.good.Rope;
import com.darren.survival.elements.good.Sawdust;
import com.darren.survival.elements.good.Snake;
import com.darren.survival.elements.good.Squirrel;
import com.darren.survival.elements.good.Stone;
import com.darren.survival.elements.good.Wire;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Forest extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final String[] nextScene = {"Plains", "Mountain", "River", "Jungle", "Lake"};
    public final int[] nextSceneWeight = {1, 1, 1, 1, 1};
    //获得物品相关
    private static final Good[] FOODS = {Rabbit.getInstance(), Squirrel.getInstance(), Snake.getInstance()};
    private static final int FOODS_PR = 15;
    private static final Good[] WOODS = {Branch.getInstance(), Firewood.getInstance(), Sawdust.getInstance()};
    private static final int WOODS_PR = 70;
    private static final Good[] BUG = {Bug.getInstance()};
    private static final int BUG_PR = 30;
    private static final Good[] HUMAN_REMAINS = {Rope.getInstance(), Lighter.getInstance(), Wire.getInstance()};
    private static final int HUMAN_REMAINS_PR = 5;
    private static final Good[] CIRRUS = {Cirrus.getInstance()};
    private static final int CIRRUS_PR = 10;
    private static final Good[] STONE = {Stone.getInstance()};
    private static final int STONE_PR = 70;
    private static final Map<Good[], Integer> GOODS_PR = new HashMap<>();

    //此场景类的名字
    public static final String Type = "Forest";
    //此场景的下一场景是否可能为终点场景
    public final String CanBEnd = "both";
    //此场景的最小及最大长度
    private static final int minLength = 20;
    private static final int maxLength = 30;
    //初始化此场景时随机长度
    private int length;
    //此场景的移动速度
    private int speed;
    //单例模式
    private static Forest forest = new Forest();

    //单例模式
    private Forest() {
        setLength(20);
        speed = 2;
        initGoods();
    }

    private void initGoods() {
        GOODS_PR.put(FOODS, FOODS_PR);
        GOODS_PR.put(WOODS,WOODS_PR);
        GOODS_PR.put(BUG,BUG_PR);
        GOODS_PR.put(HUMAN_REMAINS,HUMAN_REMAINS_PR);
        GOODS_PR.put(CIRRUS,CIRRUS_PR);
        GOODS_PR.put(STONE,STONE_PR);
    }

    //单例模式
    public static Forest getInstance() {
        return forest;
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
