package com.castor.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question_3 {

	/**
	 * "abcabcbb"
	 * @param s
	 * @return 3
	 */
	public static int lengthOfLongestSubstring(String s) {
		int start = 0, end = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while(end < s.length()) {
			if(!set.contains(s.charAt(end))){
				set.add(s.charAt(end++));
				max = Math.max(max, set.size());
			}else{
				set.remove(s.charAt(start++));
			}
		}

		return max;
	}

	/*public static int lengthOfLongestSubstring(String s) {
		char[] values = s.toCharArray();
		int begin = 0, end = 0, maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<values.length; i++){
			end = i;
			if(map.containsKey(values[i]) && map.get(values[i]) >= begin){
				begin = map.get(values[i]) + 1;
			}
			map.put(values[i], i);
			int curLength = end - begin + 1;
			maxLength = curLength > maxLength ? curLength : maxLength;
		}
		return maxLength;
	}*/

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abba"));
  }
}
