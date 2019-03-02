package com.castor.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_1 {

  public static void main(String[] args) {
  	  int[] numbers = {2, 7, 11, 15};
  	  for(int v :twoSum(numbers, 9)){
      	System.out.print( v + ",");
	  }
  }

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int value = 0;
		int need = 0;
		int[] result = new int[2];
		for(int i=0; i<nums.length; i++){
			value = nums[i];
			need = target - value;
			if(map.containsKey(need)){
				result[0] = map.get(need);
				result[1] = i;
				break;
			}
			map.put(value, i);
		}
		return result;
	}

}
