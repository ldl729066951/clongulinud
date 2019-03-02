package com.castor.leetcode;

import java.util.Optional;

public class Question_4 {

  public static void main(String[] args) {
  	int[] a = {};
  	int[] b = {-2, -1};
	System.out.println(findMedianSortedArrays(a,b));
  }

	// 0,1,2,3  1,2
	// 0,1,2    1
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int index = 0;
		int i = 0, j = 0;
		int left = 0, right = 0;
		int sum = nums1.length + nums2.length;
		while(index++ < (sum / 2) + 1){
			left = right;
			if( i < nums1.length && (j == nums2.length || (nums1[i] <= nums2[j]))){
				right = nums1[i++];
			}else{
				right = nums2[j++];
			}
		}
		return sum % 2 == 0 ? (double)(left + right)/2 : right;
	}

}
