package com.dabing.class01;

/**
 * ��ӡint��32λ��������
 */
public class PrintInt {
    public static void print(int num){
        for(int i=31;i>=0;i--){
            System.out.print((1<<i&num)==0?"0":"1");
            //1����iλ(�������ң��ƶ�֮���iλ����Ϊ1����������Ϊ0)����num���룬���ܵõ�num��iλ������0����1���������ң�
            //�磺1<<5=0000....100000
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
        print(a>>1);//11000000000000000000000000000000   ������λ����
        print(a>>>1);//01000000000000000000000000000000  ��������λ����

        System.out.println("==========================");
        //�෴��զ��ʾ��
        int b=1024;
        int c=-b;
        System.out.println(b);//1024
        System.out.println(c);//-1024
        //Ҳ����
        int d=~b+1;//ȡ��+1
        System.out.println(d);//-1024


    }

}