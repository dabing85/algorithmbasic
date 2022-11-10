package com.dabing.class02;

/**
 * 前缀和 ： 即前几个数的和
 *  [1,2,5,6,1,0,10]
 *  如2-3之间的数的和，包括2和3的数字
 */
public class PreNum {
    /**
     * 这里提供的方案是创建一个跟数组一样大小的数组，里面0-i的前缀和
     * 要求2~7之间的和的时候就是就arr[7]-arr[1]
     */
    public static int[] getPreNum(int[] arr){
        if(arr==null || arr.length<2){
            return arr;
        }
        int N=arr.length;
        int[] preNum=new int[N];
        preNum[0]=arr[0];
        for (int i = 1; i < N-1; i++) {
            preNum[i]=preNum[i-1]+arr[i];
        }
        return preNum;
    }

    /**
     * 求数组arr的第L位到第R位的之间数字的和(区域和)
     */
    public static int preNum(int[] arr,int L,int R){
        int[] preNum=getPreNum(arr);
        int ans = L==0?preNum[R]:preNum[R]-preNum[L-1];
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={1,5,0,-10,5,18,10};
        System.out.println(preNum(arr,0,0));
        System.out.println(preNum(arr,0,1));
        System.out.println(preNum(arr,0,2));
        System.out.println(preNum(arr,1,3));
    }

}
