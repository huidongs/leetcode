package leetcode.dynamicprogramming.fibonacci;

import java.util.HashMap;

/**
 * @Author: huidong
 * @Description: 斐波那契额数列：递归+备忘录算法实现
 * @Date: 2020/7/31 13:55
 * @Version: 1.0
 */
public class Fibonacci2 {
    public static int getFibonacci(int n, HashMap<Integer,Integer> hashMap){
        if (n<1){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 1;
        }
        if(hashMap.containsKey(n)){
            return hashMap.get(n);
        }else {
            int value = getFibonacci(n - 1,hashMap) + getFibonacci(n - 2,hashMap);
            hashMap.put(n,value);
            return value;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(getFibonacci(45,new HashMap<>()));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
