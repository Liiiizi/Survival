package com.darren.survival.elements.scene;

import com.darren.survival.elements.good.Branch;
import com.darren.survival.elements.good.Bug;
import com.darren.survival.elements.good.Firewood;
import com.darren.survival.elements.good.Rabbit;
import com.darren.survival.elements.good.Sawdust;
import com.darren.survival.elements.good.Stone;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Scene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Plains extends Scene {
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final String[] nextScene = {"Forest", "River", "Snowland", "Lake"};
    public final int[] nextSceneWeight = {1, 1, 1, 1};
    private static final Good[] FOODS = {Rabbit.getInstance()};
    private static final Integer[] FOODS_INFO = {50, 3};
    private static final Good[] WOODS = {Branch.getInstance(), Firewood.getInstance(), Sawdust.getInstance()};
    private static final Integer[] WOODS_INFO = {20, 1};
    private static final Good[] BUGS = {Bug.getInstance()};
    private static final Integer[] BUGS_INFO = {50, 1};
    private static final Good[] STONE = {Stone.getInstance()};
    private static final Integer[] STONE_INFO = {70, 1};
    private static final Map<Good[], Integer[]> HUNTED_GOODS = new HashMap<>();
    private static final Map<Good[], Integer[]> TOURED_GOODS = new HashMap<>();
    //此场景类的名字
    public static final String Type = "Plains";
    //此场景的下一场景是否可能为终点场景
    public final String CanBEnd = "both";
    //此场景的最小及最大长度
    private static final int minLength = 20;
    private static final int maxLength = 50;
    //初始化此场景时随机长度
    private int length = 20;
    //此场景的移动速度
    private int speed;
    //单例模式
    private static Plains plains = new Plains();

    //单例模式
    private Plains() {
        setLength(20);
        speed = 2;
        initGoods();
    }

    //单例模式
    public static Plains getInstance() {
        return plains;
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

    private void initGoods() {
        HUNTED_GOODS.put(FOODS, FOODS_INFO);
        TOURED_GOODS.put(WOODS, WOODS_INFO);
        TOURED_GOODS.put(BUGS, BUGS_INFO);
        TOURED_GOODS.put(STONE, STONE_INFO);
    }

    @Override
    public Map<Good[], Integer[]> getHuntedGoods() {
        return HUNTED_GOODS;
    }

    @Override
    public Map<Good[], Integer[]> getTouredGoods() {
        return TOURED_GOODS;
    }
}
