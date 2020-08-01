package leetcode.dynamicprogramming.fibonacci;

/**
 * @Author: huidong
 * @Description: 斐波那契数列: 递归实现 F(n)=F(n-1)+F(n-2) F(1)=1,F(2)=1
 * @Date: 2020/7/31 13:36
 * @Version: 1.0
 */
public class Fibonacci {
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
        return getFibonacci(n-1)+getFibonacci(n-2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(getFibonacci(45));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
