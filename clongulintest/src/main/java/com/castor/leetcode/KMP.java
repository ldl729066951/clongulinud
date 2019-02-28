package com.castor.leetcode;

public class KMP {

  public static void main(String[] args) {
  	  String main = "ababababca";
  	  String pattern = "abababca";

    System.out.println(kmp(main, pattern, calNext(pattern)));

  }

  //aab : a , aa   ;   ab , b

  //abababca
  //  abababca

	//a b a b a b c a
	//0 1 2 3 4 5 6 7
	//0 0 1 2 3 4 0 1
/////-1 0 0 1 2 3 4 0


	public static int[] calNext(String pattern){
		int[] next = new int[pattern.length()];
		next[0] = -1;
		int i=0, j=-1;
		while(i < pattern.length()-1){
			if(j == -1 || pattern.charAt(i) == pattern.charAt(j)){
				++j;
				++i;
				next[i] = j;
			}else{
				if(j == 0){
					i++;
				}else{
					j = next[j] == -1 ? 0 : next[j];
				}
			}
		}
		return next;
	}

	public static int kmp(String string, String pattern, int[] next){
  		int i = 0, j = 0;
  		while(i < string.length() && j < pattern.length()){
  			if(j == -1 || string.charAt(i) == pattern.charAt(j)){
  				i++;
  				j++;
			}else{
  				j = next[j];
			}
		}
		if(j == pattern.length())
			return i - j;
  		else
		    return -1;
	}

}
