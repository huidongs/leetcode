package leetcode.dynamicprogramming.goldmineofking;

import org.omg.CORBA.FREE_MEM;

/**
 * @Author: huidong
 * @Description: 动态规划实现
 * @Date: 2020/8/1 14:19
 * @Version: 1.0
 */
public class Goldmineofking3 {
    public static int getGoldmineOfKing(int n,int w,int[] g,int[] p){
        if (n>g.length){
            throw new RuntimeException("输入的n值大于给定的金矿数");
        }
        if (w<0){
            throw new RuntimeException("输入的工人数w不能为负");
        }
        if (n<1||w==0){
            return 0;
        }
        int col = w+1;//因为F(x,0)也要用到，所以表格应该有w+1列
        int[] preResults = new int[col];
        int[] results = new int[col];
        //初始化第一行边界
        for (int i = 0;i<col;i++){
            if (i<p[0]){
                preResults[i]=0;
            }else {
                preResults[i]=g[0];
            }
        }
        if (n==1){
            return preResults[w];
        }
        //用上一行推出下一行，外循环控制递推的轮数（金矿数），内循环进行递推（工人数）
        for (int i = 1; i<n;i++){
            for (int j = 0;j<col;j++){
                if (j<p[i])
                    results[j]=preResults[j];
                else
                    results[j]=Math.max(preResults[j],preResults[j-p[i]]+g[i]);
            }
            //更新上一行的值，为下一轮递推做准备；
            for (int j = 0;j<col;j++)
            {
                preResults[j]=results[j];
            }
        }
        return results[w];
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
