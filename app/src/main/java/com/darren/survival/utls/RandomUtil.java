package com.darren.survival.utls;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Darren on 2015/12/6 0006.
 */
public class RandomUtil {
    public static final Random r = new Random();

    public static int nextInt(int n) {
        return r.nextInt(n);
    }

    public static boolean nextBoolean() {
        return r.nextBoolean();
    }

    /*
   * 按照顺序依次传入随机选项及其权重
   * eg:{A,1,B,2,C,1,D,2}
   * 没有进行异常处理 不要尝试传入错误参数
    */
    public static String randomByWeight(String[] items) {
        ArrayList<String> itemList = new ArrayList<String>();
        ArrayList<Integer> weightList = new ArrayList<Integer>();
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            if (i % 2 == 0) itemList.add(items[i]);
            else {
                weightList.add(Integer.parseInt(items[i]));
                total += Integer.parseInt(items[i]);
            }
        }

        int number = nextInt(total);
        for (int i = 0; ; i++) {
            number -= weightList.get(i);
            if (number <= 0) return itemList.get(i);
        }
    }
    /*
    *items： 随机选项
    * weight: 每个选项的权重
    * 没有进行异常处理 不要尝试传入错误参数
     */
    public static String randomByWeight(String[] items,int[] weights) {
        int total = 0;
        for(int i=0; i<weights.length; i++) {
            total += weights[i];
        }

        int number = nextInt(total);
        for (int i = 0; ; i++) {
            number -= weights[i];
            if (number <= 0) return items[i];
        }
    }

}
