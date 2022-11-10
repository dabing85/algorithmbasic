package com.dabing.class03;

import java.util.Arrays;


public class BSNearLeft {

    /**
     * 有序数组中找到>=num最左的位置
     * 如有序数组[1,2,2,2,3,5,8,9,11]
     * num=2;
     * 则>=2的最左下标为1.
     *
     */
    public static int mostLeftNoLessNumIndex(int[] arr, int num){
        if(arr==null || arr.length==0){
            return -1;
        }
        int L=0;
        int R=arr.length-1;
        int index=-1;
        while (L<=R){
            int mid=(L+R)/2;
            if(arr[mid]>=num){
                index=mid;
                R=mid-1;
            }else {
                L=mid+1;
            }
        }
        return index;
    }

    //随机有序数组
    public static int[] randomArr(int maxLen,int maxNum){
        int length= (int)(Math.random() * (maxLen+1));
        int[] arr=new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]=(int)(Math.random()* (maxNum+1));
        }
        Arrays.sort(arr);
        return arr;
    }

    //对数
    public static int testIndex(int[] arr,int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=num){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int times=50000;
        int maxNum=100;
        int maxLen=10;
        boolean succeed = true;
        for (int i = 0; i < times; i++) {
            int num=(int)(Math.random()*(maxNum+1));
            int[] arr=randomArr(maxLen,maxNum);
            if(mostLeftNoLessNumIndex(arr,num) != testIndex(arr,num)){
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
