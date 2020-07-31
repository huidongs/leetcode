package leetcode.dynamicprogramming;

/**
 * @Author: huidong
 * @Description: 十层楼梯问题，递归实现 ; 时间复杂度O(2^n)
 *                  n=43 time=1164ms;
 *                  n=44 time=1879ms;
 *                  n=45 time=3005ms;
 *                  n=46 time=4850ms;结果已超出int范围
 * @Date: 2020/7/30 22:29
 * @Version: 1.0
 */
public class Tensteps {
    public static int getClimbingWays(int n){
        if (n<1){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        return getClimbingWays(n-1)+getClimbingWays(n-2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(getClimbingWays(43));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
