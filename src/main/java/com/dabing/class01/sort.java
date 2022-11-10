package com.dabing.class01;

public class sort {
    /**
     * 选择排序
     * 每次都中i~n-1中选择出一个最小的数放前面
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
     * 冒泡排序
     * 每次相邻的两位数字对比，如果前一位比后一位大，则交换位置，这样每次下来最大的数字就会跑到队尾去了
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
     * 插入排序
     * 像你玩扑克整牌一样，手上的牌已经有序了，你新拿来一个牌，从右往左一个一个对比，找到自己的位置插入
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
