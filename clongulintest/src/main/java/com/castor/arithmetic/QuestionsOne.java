package com.castor.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		//^[+-]?\d*\.\d*$
		//"^([1-9][0-9]*)(.[0-9]{0,1})?$";
		String regExp = "^[1-9][0-9]*(\\.[0-9]{0,1})?$"; //n为小数位数
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher("00");
		System.out.println(m.matches());

	}

}
