package com.castor.sort;

/**
 * 快速排序：
 *
 * 算法描述：对于一组给定的记录，通过一趟排序后，将原序列分为两部分，其中前一部分的所有记录均比后一部分的所有记录小，
 * 然后再依次对前后两部分的记录进行快速排序，递归该过程，直到序列中的所有记录均有序为止。
 *
 * 平均O(nlogn),最好O(nlogn),最坏O(n^2);空间复杂度O(nlogn);不稳定;较复杂
 */
public class QuickSort {

    public static void main(String[] args){
        int[] a ={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        quickSort(a, 0, a.length-1);
        for(int j:a)
            System.out.print(j+" ");
    }

    public static void quickSort(int[] a, int s_start, int s_end){
        int start = s_start;
        int end = s_end;
        int key = a[s_start];


        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key) //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，
            //右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>s_start) quickSort(a,s_start,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<s_end) quickSort(a,end+1,s_end);//右边序列。从关键值索引+1到最后一个
    }

}
