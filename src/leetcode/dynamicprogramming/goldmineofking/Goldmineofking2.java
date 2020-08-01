package leetcode.dynamicprogramming.goldmineofking;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author: huidong
 * @Description: 递归+备忘录算法实现
 * @Date: 2020/7/31 22:26
 * @Version: 1.0
 */
public class Goldmineofking2 {
    /**
     * @author huidong
     * @describe 该内部类对象用于备忘录算法中作为HashMap存储的键
     */
    private static class Numberofgoldmineandworker {
        public int n;
        public int w;

        public Numberofgoldmineandworker(int n, int w) {
            //super()是当前对象的直接父类的无参的构造函数
            super();
            this.n = n;
            this.w = w;
        }

        //        @Override
//        public int hashCode() {
//            return Objects.hash(n, w);
//        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + n;
            result = prime * result + w;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Numberofgoldmineandworker that = (Numberofgoldmineandworker) o;
            return n == that.n &&
                    w == that.w;
        }
    }

    /**
     * @author huidong
     * @describe 该方法用于获取最大黄金量:备忘录算法
     */
    public static int getGoldmineOfKing(int n, int w, int[] g, int[] p, HashMap<Numberofgoldmineandworker, Integer> hashMap) {
        if (n > g.length) {
            throw new RuntimeException("输入的n值大于给定的金矿数");
        }
        if (n <= 1 && w < p[0]) {
            return 0;
        }
        if (n == 1 && w >= p[0]) {
            return g[0];
        }
        if (n > 1 && w < p[n - 1]) {
            Numberofgoldmineandworker input = new Numberofgoldmineandworker(n - 1, w);
            if (hashMap.containsKey(input))
                return hashMap.get(input);
            int value = getGoldmineOfKing(n - 1, w, g, p, hashMap);
            hashMap.put(input, value);
            return value;
        }
        Numberofgoldmineandworker input1 = new Numberofgoldmineandworker(n - 1, w);
        Numberofgoldmineandworker input2 = new Numberofgoldmineandworker(n - 1, w - p[n - 1]);
        int a = 0; //用于记录F(n-1,w)的值
        int b = 0; //用于记录F(n-1,w-p[n-1])+g[n-1])的值
        if (hashMap.containsKey(input1)) {
            a = hashMap.get(input1);
        }else {
            a = getGoldmineOfKing(n - 1, w, g, p, hashMap);
            hashMap.put(input1,a);
        }
        if (hashMap.containsKey(input2)){
            b=hashMap.get(input2)+g[n-1];
        }else {
            b = getGoldmineOfKing(n - 1, w-p[n-1], g, p, hashMap);
            hashMap.put(input2,b);
            b=b+g[n-1];
        }
        return Math.max(a,b);

    }

    public static void main(String[] args) {
        int[] G = {400,500,200,300,350};
        int[] P = {5,5,3,4,3};
        long startTime = System.currentTimeMillis();
        System.out.println(getGoldmineOfKing(5, 10, G, P, new HashMap<>()));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}


