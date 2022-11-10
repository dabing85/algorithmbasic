package com.dabing.class02;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * �������
 * Math.random()  [0,1)֮������ȸ������
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
     * ���� Math.random() �Ƿ�ȸ���
     * �������0.5
     */
    public static void testP(){
        int testTimes=10000000;//ִ��100���
        int count=0;
        double p=0d;
        for (int i = 0; i < testTimes; i++) {
            double ans=Math.random();
            if(ans<0.5){
                count++;
            }
        }
        p=(double)count/(double)testTimes;
        System.out.println(p);//0.4999083    ��<0.5�ĸ��ʣ�����Լ����0.5˵���ǵȸ��ʵġ�
    }

    /**
     * ��[0,1)�ó������������Χ
     */
    public static void otherRand(){
        System.out.println("------------");
        //[0,8)���  Math.random()*8
        double ans1=Math.random()*8;
        System.out.println(ans1);
        //�����Ƿ�ȸ���
        int count=0;
        for (int i = 0; i < 10000000; i++) {
            if(Math.random()*8 < 5){
                count++;
            }
        }
        System.out.println((double)count/(double)10000000);//0.624981
        System.out.println((double)5/(double)8);  //0.625
        System.out.println("------------");

        //[0,8),��[0,7]�������
        int ans2=(int)(Math.random()*8);
        System.out.println(ans2);
        //�����Ƿ�ȸ���
        int[] arr2=new int[8];
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if((int)(Math.random()*8)==j){
                    arr2[j]++;
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("����"+i+"���֣�"+arr2[i]+"��");
        }
        System.out.println("------------");
        //[1��5]�������
        int ans3=(int)(Math.random()*5)+1;
        System.out.println(ans3);

    }


    /**
     * �ɺ���f()--->�õ�[1,7]���������
     * ��������Ƚ�ͨ��
     * ��f()��ʾ�õ�[1,5]���������
     */
    public static int f(){
        return (int)(Math.random() * 5)+1;
    }

    /**
     * ��f()--->�ȸ��ʷ���0��1
     */
    public static int f1(){
        int ans=0;
        do{
            ans=f();
        }while (ans==3);
        return ans<3 ? 0 : 1;
    }

    /**
     * ��֤f�Ƿ�ȸ��ʷ����������
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
            System.out.println("����"+(i)+"���֣�"+arr2[i]+"��");
        }
        System.out.println("------------");
    }

    /**
     * ��f1()---->�ȸ��ʷ���[0,7]���������
     */
    public static int f2(){
        return (f1()<<2) + (f1()<<1) + (f1()<<0);
    }

    /**
     * ��f2()--->�ȸ��ʷ���[1,7]
     * ����0����
     */
    public static int f3(){
        int ans=0;
        do{
            ans=f2();
        }while (ans==0);
        return ans;
    }


    /**
     * ����ͨ�õģ�����һ��RandomBox,�ȸ��ʷ������ⷶΧ���������
     * Ȼ������ͨ�����RandomBox��ʵ�ֵȸ��ʷ���ָ����Χ���������
     */
    public static class RandomBox {
        // ����ṹ��Ψһ���������
        // ��ֻ�ܳ�ʼ����ʹ�ã������޸�
        private final int min;
        private final int max;

        // ��ʼ��ʱ��һ����Ҫ��mi==ma
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
        //�ж��Ƿ�Ϊ����
        int size=max-min+1;
        boolean odd = size % 2 == 1 ; //��2ȡ��Ϊ1��Ϊ����
        int mid=size/2;
        int ans=0;
        do{
            ans=randomBox.random()-min;
        }while (odd && ans==mid);
        return ans < mid ? 0 : 1;
    }

    // ����һ��RandomBox������Ψһ�ܽ������������
    // �ȸ��ʷ���from~to��Χ���κ�һ����
    // Ҫ��from<=to
    public static int random(RandomBox randomBox, int from, int to) {
        if (from == to) {
            return from;
        }
        // 3 ~ 9
        // 0 ~ 6
        // 0 ~ range
        int range = to - from;
        int num = 1;
        // ��0��range��Ҫ����2����λ
        while ((1 << num) - 1 < range) {
            num++;
        }

        // ����һ����Ҫnumλ
        // ���յ��ۼӺͣ�����+0λ����1����0��1λ����1����0��2λ����1����0...
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
     * ���������С���������
     * @param maxLen ��󳤶�
     * @param maxVal �������
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
     *�����������
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
