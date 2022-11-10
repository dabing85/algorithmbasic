package com.dabing.class02;

/**
 * ǰ׺�� �� ��ǰ�������ĺ�
 *  [1,2,5,6,1,0,10]
 *  ��2-3֮������ĺͣ�����2��3������
 */
public class PreNum {
    /**
     * �����ṩ�ķ����Ǵ���һ��������һ����С�����飬����0-i��ǰ׺��
     * Ҫ��2~7֮��ĺ͵�ʱ����Ǿ�arr[7]-arr[1]
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
     * ������arr�ĵ�Lλ����Rλ��֮�����ֵĺ�(�����)
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
