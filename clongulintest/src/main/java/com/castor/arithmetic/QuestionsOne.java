package com.castor.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class QuestionsOne {

	public int[] twoSum(int[] nums, int target) {
		int[] res = null;
		for(int i=0; i<nums.length - 1; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					res = new int[]{i,j};
					break;
				}else{
					continue;
				}
			}
		}
		return res;
	}

	public static int[] twoSum1(int[] nums, int target) {
		int[] res = null;
		Map<Integer,Integer> maps = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int other = target - nums[i];
			if(maps.containsKey(other)){
				res = new int[]{i, maps.get(other)};
				break;
			}
			maps.put(nums[i], i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] res = new int[]{2, 7, 11, 15};
		twoSum1(res, 9);
	}

}
