package com.darren.survival.elements.model;

import com.darren.survival.elements.motion.people.Hunter;
import com.darren.survival.elements.motion.people.Tourer;
import com.darren.survival.utls.RandomUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class Scene {

    //场景类的路径，用来根据String获得实例
    public static final String packagePath = "com.darren.survival.elements.scene.";
    //终点的概率
    public static final int PROBABLITY1_3 = 0;
    public static final int PROBABLITY4_5 = 10;
    public static final int PROBABLITY6_9 = 30;
    public static final int PROBABLITY10 = 50;
    public static final int PROBABLITY11 = 70;
    public static final int PROBABLITY12 = 100;
    //nextScene：可能的下一场景 nextSceneWeight:每个场景可能出现的权重
    public final String[] nextScene = {"Forest","Plains", "Mountain", "River", "Iceberg", "Snowland", "Jungle", "Lake"};
    public final int[] nextSceneWeight = {1,1,1,1,1,1,1,1};
    //场景类名字，用来重载
    public static final String Type = null;
    //此场景的下一场景是否可能为终点场景，用来重载
    public final String CanBEnd = "none";
    //此场景的最小及最大长度
    private static final int minLength = 0;
    private static final int maxLength = 0;
    //初始化此场景时随机长度，用来重载
    private int length;
    //记录已经到达的场景数
    public static int count = 0;
    //此场景的移动速度
    private int speed;
    //下一随机场景
    public Scene getNext() {
        count++;

        String strScene = null;
        String strEnd = RandomUtil.randomByWeight(new String[]{"none", getCanBEnd()}, new int[]{100 - getEndProbablity(), getEndProbablity()});
        if(strEnd.equals("none")) {
            strScene = RandomUtil.randomByWeight(getNextScene(), getNextSceneWeight());
        } else {
            String[] strEnds = null;
            if(strEnd.equals("both")){
                strScene = RandomUtil.randomByWeight(new String[]{"Road","Town"},new int[]{1,1});
            } else {
                strScene = strEnd;
            }
        }
        Scene temp = null;
        try {
            temp = (Scene)Class.forName(packagePath + strScene).getMethod("getInstance").invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
    //终点场景出现的可能性
    public int getEndProbablity() {
        switch (count) {
            case 1:
            case 2:
            case 3:
                return PROBABLITY1_3;
            case 4:
            case 5:
                return PROBABLITY4_5;
            case 6:
            case 7:
            case 8:
            case 9:
                return PROBABLITY6_9;
            case 10:
                return PROBABLITY10;
            case 11:
                return PROBABLITY11;
            case 12:
                return PROBABLITY12;
            default:
                return PROBABLITY12;
        }
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

    public Map<Good[], Integer[]> getHuntedGoods() {
        return null;
    }

    public Map<Good[], Integer[]> getTouredGoods() {
        return null;
    }

    public Map<Good[], Integer[]> getGoods(Motion motion) {
        if(motion == Hunter.getInstance()) return getHuntedGoods();
        if(motion == Tourer.getInstance()) return getTouredGoods();
        return null;
    }

    public String getName() {
        String[] strTemp = getClass().getName().toString().split("\\.");
        String strName = strTemp[strTemp.length - 1];
        return strName;
    }
}
