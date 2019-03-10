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
        quickSort2(a, 0, a.length-1);
        for(int j:a)
            System.out.print(j+" ");
    }

    public static int partition(int[] a, int s_start, int s_end){

        int i = s_start + 1;
        int j = s_end;
        int key = a[s_start];
        int tmp;

        while(true){
            while(i<j && a[i] <= key) i++;
            while(i<j && a[j] >= key) j--;

            if(i >= j) break;

            tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;

        }
        if(a[j] < key){
            a[s_start] = a[j];
            a[j] = key;
        }
        return j;
    }

  public static void quickSort2(int[] a, int s_start, int s_end) {
        if(s_start < s_end){
            int center = partition(a, s_start,s_end);
            if(s_start < center){
                System.out.println("OOO::start:"+s_start + ",end:"+s_end + ", " + s_start + "::" + (center -1));
                quickSort2(a, s_start, center -1);
            }
            if(center < s_end){
                System.out.println("PPP::start:"+s_start + ",end:"+s_end + ", "   + (center +1) + "::" + s_end);
                quickSort2(a, center+1 , s_end);
            }

        }


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
