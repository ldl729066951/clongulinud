package com.castor.leetcode;

import java.util.Stack;

public class Question_5 {
	private int lo, maxLen;

	public static void main(String[] args) {

		System.out.println(new Question_5().longestPalindrome("ac"));
	}


	public String longestPalindrome(String s) {
		if(s == null || s.length() <=1) return s;
		for(short i=0; i<s.length()-1; i++){
			matching(s, i, i);
			matching(s, i, i+1);
		}
		return s.substring(lo, lo + maxLen);
	}

	private void matching(String s, int i, int j){
		while (i >=0 && j< s.length() && s.charAt(i) == s.charAt(j)){
			i--;
			j++;
		}
		if(maxLen < j-i-1){
			lo = i +1;
			maxLen = j-i-1;
		}
	}




























	/*public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len-1; i++) {
			extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i+1); //assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}*/


}
