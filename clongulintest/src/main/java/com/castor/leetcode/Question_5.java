package com.castor.leetcode;

import java.util.Stack;

public class Question_5 {
	private int lo, maxLen;

	public static void main(String[] args) {

		System.out.println(new Question_5().longestPalindrome("xabax"));
	}

	public String longestPalindrome(String s) {
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
	}






	/*public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}*/

























	/**
	 * 最长回文子串
	 * "babad" -> "bab" , "aba"
	 * @param s
	 * @return
	 */
	public String longestPalindrome1(String s) {
		if(s.length() == 0) return s;
		Stack<Tuple> stack = new Stack<>();
		int start=0,end=0,maxLenth=0;
		int j=0;

		while(j<s.length()){

			if(!stack.empty() && stack.peek().getVal() == s.charAt(j)){



			}
			stack.push(new Tuple(s.charAt(j), j));
		}
		return null;
	}

	class Tuple{

		private Character val;
		private Integer index;
		private Tuple next;

		public Tuple(Character val, Integer index) {
			this.val = val;
			this.index = index;
		}

		public Character getVal() {
			return val;
		}

		public void setVal(Character val) {
			this.val = val;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

		public Tuple getNext() {
			return next;
		}

		public void setNext(Tuple next) {
			this.next = next;
		}
	}

}
