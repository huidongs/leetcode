package leetcode.dynamicprogramming.fibonacci;

/**
 * @Author: huidong
 * @Description: 斐波那契数列 ：动态规划实现：迭代
 * @Date: 2020/7/31 16:12
 * @Version: 1.0
 */
public class Fibonacci3 {
    public static int getFibonacci(int n){
        if (n<1){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int temp=0;
        for (int i = 3;i<=n;i++){
            temp = a+b;
            a = b;
            b = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(getFibonacci(10));
    }
}
