package leetcode.dynamicprogramming;

/**
 * @Author: huidong
 * @Description: 递归+备忘录算法+迭代减少空间复杂度   真正的动态规划！！！
 * @Date: 2020/7/30 23:37
 * @Version: 1.0
 */
public class Tensteps3 {
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
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3;i<=n;i++){
            temp = a+b;
            a=b;
            b=temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(getClimbingWays(40));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
