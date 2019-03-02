package com.castor.sort;

/**
 * 插入排序：
 * 基本思想：对于给定的一个数组，初始时假设第一个记录自成一个有序序列，其余记录为无序序列。
 * 接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，直至最后一个记录插入到有序序列中为止.
 *
 * 平均O(n^2),最好O(n),最坏O(n^2);空间复杂度O(1);稳定;简单
 */
public class InsertSort {

    public static void insertSort(int[] a){

        int temp = 0;
        for(int i=1; i<a.length; i++){
            for(int j=i-1; j>=0; j--){
                if(a[j] > a[j+1]){
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        insertSort(a);
        for(int i: a){
            System.out.println(i);
        }
    }

}
