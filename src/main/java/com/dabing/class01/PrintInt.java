package com.dabing.class01;

/**
 * 打印int的32位二进制码
 */
public class PrintInt {
    public static void print(int num){
        for(int i=31;i>=0;i--){
            System.out.print((1<<i&num)==0?"0":"1");
            //1左移i位(从左往右，移动之后第i位数字为1，其他数字为0)再与num相与，就能得到num第i位数字是0还是1（从左往右）
            //如：1<<5=0000....100000
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(1);//00000000000000000000000000000001
        print(4);//00000000000000000000000000000100
        print(0);//00000000000000000000000000000000
        print(-1);//11111111111111111111111111111111
        print(-4);//11111111111111111111111111111100

        System.out.println("==========================");

        int a=Integer.MIN_VALUE;
        print(a);//10000000000000000000000000000000
        print(a>>1);//11000000000000000000000000000000   带符号位右移
        print(a>>>1);//01000000000000000000000000000000  不带符号位右移

        System.out.println("==========================");
        //相反数咋表示？
        int b=1024;
        int c=-b;
        System.out.println(b);//1024
        System.out.println(c);//-1024
        //也可以
        int d=~b+1;//取反+1
        System.out.println(d);//-1024


    }

}