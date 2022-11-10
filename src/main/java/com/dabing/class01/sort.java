package com.dabing.class01;

public class sort {
    /**
     * ѡ������
     * ÿ�ζ���i~n-1��ѡ���һ����С������ǰ��
     * @param arrs
     */
    public static void  selectSort(int[] arrs){
        if(arrs == null || arrs.length<2){
            return;
        }
        //0~n-1
        //1~n-1
        //2~n-1
        //n-2~n-1
        for (int i = 0; i < arrs.length; i++) {
            int minValue=i;
            for (int j = i; j < arrs.length; j++) {
                minValue=arrs[j]<arrs[minValue] ? j : minValue;
            }
            swap(arrs,i,minValue);
        }
    }

    /**
     * ð������
     * ÿ�����ڵ���λ���ֶԱȣ����ǰһλ�Ⱥ�һλ���򽻻�λ�ã�����ÿ�������������־ͻ��ܵ���βȥ��
     * @param arrs
     */
    public static void bubbleSort(int[] arrs){
        if(arrs==null || arrs.length<2){
            return ;
        }
        //0~n-1
        //0~n-2
        //0~n-3
        //0~1
        int N=arrs.length;
        for (int end=N-1;end>=0;end--) {
            //0~end
            // 0 1   1 2   2 3  ....
            for (int second = 1; second <= end; second++) {
                if(arrs[second-1]>arrs[second])
                    swap(arrs,second-1,second);
            }
        }
    }

    /**
     * ��������
     * �������˿�����һ�������ϵ����Ѿ������ˣ���������һ���ƣ���������һ��һ���Աȣ��ҵ��Լ���λ�ò���
     * @param arrs
     */
    public static void insertSort1(int[] arrs){
        if(arrs==null || arrs.length<2){
            return ;
        }
        //0~1
        //0~2
        //0~3
        //0~n-1
        int N=arrs.length;
        for (int i = 1; i < N; i++) {
            int endNum=i;
            while(endNum-1>0 && arrs[endNum]<arrs[endNum-1]){
                swap(arrs,endNum,endNum-1);
                endNum--;
            }
        }
    }

    public static void insertSort2(int[] arrs){
        if(arrs==null || arrs.length<2){
            return ;
        }
        //0~1
        //0~2
        //0~3
        //0~n-1
        int N=arrs.length;
        for (int i = 1; i < N; i++) {

            for(int endNum=i;endNum-1>0 && arrs[endNum-1]>arrs[endNum] ;endNum -- ){
                swap(arrs,endNum,endNum-1);
            }
        }
    }

    public static void swap(int[] arrs,int i,int j){
        int tmp=arrs[i];
        arrs[i]=arrs[j];
        arrs[j]=tmp;
    }

    public static void printArray(int[] arrs){
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arrs={1,5,4,17,5,1,3,5,8,9,4,10};
        printArray(arrs);
//        selectSort(arrs);
//        bubbleSort(arrs);
        insertSort1(arrs);
        printArray(arrs);
    }
}
