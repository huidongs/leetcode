package leetcode.dynamicprogramming.goldmineofking;

import java.util.HashMap;

/**
 * @Author: huidong
 * @Description: 国王的金矿问题：简单递归实现
 * @Date: 2020/7/31 21:22
 * @Version: 1.0
 */
public class Goldmineofking {
    public static int getGoldmineOfKing(int n, int w, int[] g, int[] p) {
        if (n <= 1 && w < p[0]) {
            return 0;
        }
        if (n == 1 && w >= p[0]) {
            return g[0];
        }
        if (n > 1 && w < p[n - 1]) {
            return getGoldmineOfKing(n - 1, w, g, p);
        }
        return Math.max(getGoldmineOfKing(n - 1, w, g, p), getGoldmineOfKing(n - 1, w - p[n - 1], g, p) + g[n - 1]);
    }

    public static void main(String[] args) {
        int[] G = {400,500,200,300,350};
        int[] P = {5,5,3,4,3};
        long startTime = System.currentTimeMillis();
        System.out.println(getGoldmineOfKing(5,10,G,P));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
