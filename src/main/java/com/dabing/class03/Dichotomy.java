package com.dabing.class03;

import java.util.Arrays;

public class Dichotomy {
    public static void main(String[] args) {
        int times=10000;
        int maxNum=100;
        int maxLen=10;
        boolean succeed = true;
        for (int i = 0; i < times; i++) {
            int num=(int)(Math.random()*(maxNum+1));
            int[] arr=randomArr(maxLen,maxNum);
            if(find(arr,num) != testFind(arr,num)){
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }

    //有序数组中找到num
    //二分法
    public static boolean find(int arr[] ,int num){
        if(arr==null|| arr.length==0){
            return false;
        }
        int L=0;
        int R=arr.length-1;
        while (L <= R){
            int mid=(L+R)/2;
            if(arr[mid]==num){
                return true;
            }
            if(arr[mid]<num){
                L=mid+1;
            }
            if(arr[mid]>num){
                R=mid-1;
            }
        }
        return false;

    }


    //对数器
    public static int[] randomArr(int maxLen,int maxNum){
        int length= (int)(Math.random() * (maxLen+1));
        int[] arr=new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]=(int)(Math.random()* (maxNum+1));
        }
        Arrays.sort(arr);
        return arr;
    }
    //打印数组
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //对数
    public static boolean testFind(int[] arr,int num){
        for (int cur : arr) {
            if(cur==num)
                return true;
        }
        return false;
    }

}
