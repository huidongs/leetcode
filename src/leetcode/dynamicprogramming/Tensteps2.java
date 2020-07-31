package leetcode.dynamicprogramming;

import java.util.HashMap;

/**
 * @Author:
 * @Description: 动态规划，爬楼梯问题：递归+备忘录算法实现;  时间复杂度O(n)，参数已经可以设置几千了；
 *
 * @Date: 2020/7/30 22:41
 * @Version: 1.0
 */
public class Tensteps2 {
    public static int getClimbingWays(int n, HashMap<Integer,Integer> hashMap){
        if (n<1){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        if (hashMap.containsKey(n)){
            return hashMap.get(n);
        }else {
            int value = getClimbingWays(n - 1,hashMap) + getClimbingWays(n - 2,hashMap);
            hashMap.put(n,value);
            return value;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(getClimbingWays(3000,new HashMap<>()));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
