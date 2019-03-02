package com.castor.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question_5 {

  public static void main(String[] args) {

	  ExecutorService executorService = Executors.newCachedThreadPool();

    System.out.println(new Question_5().longestPalindrome("abcda"));
  }

	/**
	 * 最长回文子串
	 * "babad" -> "bab" , "aba"
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
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
