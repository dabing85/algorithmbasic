package com.dabing.class02;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 随机函数
 * Math.random()  [0,1)之间的数等概率随机
 */
public class RandNum {
    public static void main(String[] args) {
//        testP();
//        otherRand();
//       testP01();
        for (int i = 0; i < 50; i++) {
            printArray(orderRandArr(50,500));
        }

    }

    /**
     * 测试 Math.random() 是否等概率
     * 这里测试0.5
     */
    public static void testP(){
        int testTimes=10000000;//执行100万次
        int count=0;
        double p=0d;
        for (int i = 0; i < testTimes; i++) {
            double ans=Math.random();
            if(ans<0.5){
                count++;
            }
        }
        p=(double)count/(double)testTimes;
        System.out.println(p);//0.4999083    即<0.5的概率，这里约等于0.5说明是等概率的。
    }

    /**
     * 由[0,1)得出其他的随机范围
     */
    public static void otherRand(){
        System.out.println("------------");
        //[0,8)随机  Math.random()*8
        double ans1=Math.random()*8;
        System.out.println(ans1);
        //测试是否等概率
        int count=0;
        for (int i = 0; i < 10000000; i++) {
            if(Math.random()*8 < 5){
                count++;
            }
        }
        System.out.println((double)count/(double)10000000);//0.624981
        System.out.println((double)5/(double)8);  //0.625
        System.out.println("------------");

        //[0,8),即[0,7]整数随机
        int ans2=(int)(Math.random()*8);
        System.out.println(ans2);
        //测试是否等概率
        int[] arr2=new int[8];
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if((int)(Math.random()*8)==j){
                    arr2[j]++;
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("数字"+i+"出现："+arr2[i]+"次");
        }
        System.out.println("------------");
        //[1，5]整数随机
        int ans3=(int)(Math.random()*5)+1;
        System.out.println(ans3);

    }


    /**
     * 由函数f()--->得到[1,7]的随机整数
     * 这个方法比较通用
     * 如f()表示得到[1,5]的随机整数
     */
    public static int f(){
        return (int)(Math.random() * 5)+1;
    }

    /**
     * 由f()--->等概率返回0和1
     */
    public static int f1(){
        int ans=0;
        do{
            ans=f();
        }while (ans==3);
        return ans<3 ? 0 : 1;
    }

    /**
     * 验证f是否等概率返回随机整数
     */
    public static void testP01(){
        RandomBox randomBox=new RandomBox(15,29);
        int[] arr2=new int[2];
        int ans=0;
        for (int i = 0; i < 10000000; i++) {
            ans=rand01(randomBox);
            if(ans==0)
                arr2[0]++;
            if (ans==1)
                arr2[1]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("数字"+(i)+"出现："+arr2[i]+"次");
        }
        System.out.println("------------");
    }

    /**
     * 由f1()---->等概率返回[0,7]的随机整数
     */
    public static int f2(){
        return (f1()<<2) + (f1()<<1) + (f1()<<0);
    }

    /**
     * 由f2()--->等概率返回[1,7]
     * 遇到0重做
     */
    public static int f3(){
        int ans=0;
        do{
            ans=f2();
        }while (ans==0);
        return ans;
    }


    /**
     * 更加通用的，给你一个RandomBox,等概率返回任意范围的随机整数
     * 然后让你通过这个RandomBox来实现等概率返回指定范围的随机整数
     */
    public static class RandomBox {
        // 这个结构是唯一的随机机制
        // 你只能初始化并使用，不可修改
        private final int min;
        private final int max;

        // 初始化时请一定不要让mi==ma
        public RandomBox(int mi, int ma) {
            min = mi;
            max = ma;
        }

        // 13 ~ 17
        // 13 + [0,4]
        public int random() {
            return min + (int) (Math.random() * (max - min + 1));
        }

        public int min() {
            return min;
        }

        public int max() {
            return max;
        }
    }

    public static int rand01(RandomBox randomBox){
        int min=randomBox.min();
        int max=randomBox.max();
        //判断是否为奇数
        int size=max-min+1;
        boolean odd = size % 2 == 1 ; //与2取余为1即为奇数
        int mid=size/2;
        int ans=0;
        do{
            ans=randomBox.random()-min;
        }while (odd && ans==mid);
        return ans < mid ? 0 : 1;
    }

    // 给你一个RandomBox，这是唯一能借助的随机机制
    // 等概率返回from~to范围上任何一个数
    // 要求from<=to
    public static int random(RandomBox randomBox, int from, int to) {
        if (from == to) {
            return from;
        }
        // 3 ~ 9
        // 0 ~ 6
        // 0 ~ range
        int range = to - from;
        int num = 1;
        // 求0～range需要几个2进制位
        while ((1 << num) - 1 < range) {
            num++;
        }

        // 我们一共需要num位
        // 最终的累加和，首先+0位上是1还是0，1位上是1还是0，2位上是1还是0...
        int ans = 0;
        do {
            ans = 0;
            for (int i = 0; i < num; i++) {
                ans |= (rand01(randomBox) << i);
            }
        } while (ans > range);
        return ans + from;
    }

    /**
     * 生成随机大小的随机序列
     * @param maxLen 最大长度
     * @param maxVal 最大数字
     * @return
     */
    public static int[] randArrs(int maxLen,int maxVal){
        int length=(int)(Math.random()*(maxLen+1));
        int[] arr=new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]=(int)(Math.random()*(maxVal+1));
        }
        return arr;
    }

    /**
     *随机有序序列
     */
    public  static int[] orderRandArr(int maxLen,int maxVal){
        int[] arr=randArrs(maxLen,maxVal);
        Arrays.sort(arr);
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
