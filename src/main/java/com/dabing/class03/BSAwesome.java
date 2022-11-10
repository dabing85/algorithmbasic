package com.dabing.class03;

import java.util.Arrays;

/**
 * 局部最小值问题
 * 序列：无序，但任意相邻的数不相等
 * 局部最小：
 * 1）0 1 x x x x .....    第一个0是局部最小
 * 2) ....x x x x 8 2     最后的2是局部最小
 * 3）...x 8 3 9 x x x     中间的3是局部最小
 */
public class BSAwesome {
    /**
     * 局部最小值下标
     */
    public static int oneMinIndex(int[] arr){
        if(arr==null || arr.length==0){
            return -1;
        }
        int N=arr.length;
        if(N==1){
            return 0;
        }
        if(arr[0]<arr[1]){
            return 0;
        }
        if(arr[N-1]<arr[N-2]){
            return N-1;
        }

        int L=0;
        int R=N-1;
        while(L< R-1){
            int mid=(L+R)/2;
            if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]){
                return mid;
            }else if(arr[mid]>arr[mid-1]){
                R=mid-1;
            }else {
                L=mid+1;
            }

        }
        return  arr[L] < arr[R] ? L : R;
    }

    //随机无序相邻不等序列
    public static int[] randomArr(int maxLen,int maxNum){
        int length= (int)(Math.random() * (maxLen+1));
        int[] arr=new int[length];
        if(length>0){
            arr[0]=(int)(Math.random()* (maxNum+1));
            for (int i =1 ;i<length;i++ ) {
                do{
                    arr[i]=(int)(Math.random()* (maxNum+1));
                }while(arr[i]==arr[i-1]);

            }
        }
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
    public static boolean test(int[] arr,int minIndex){
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArr(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!test(arr, ans)) {
                printArr(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
