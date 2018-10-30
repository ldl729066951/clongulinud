package com.castor.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * //排列组合
 */
public class TestA {

	public static void main(String[] args) {
		String[] a = new String[] { "a", "b", "c", "d" };
		List<String> list = Arrays.asList(a);
		List<List<Object>> aa = str(list);
		for(List<Object> ss:aa){
			for(Object s:ss){
				System.out.print(s+",");
			}
			System.out.println();
		}
	}
	public static List<List<Object>> str(List<String> list) {
		List<List<Object>> result = new ArrayList<List<Object>>();
		long n = (long)Math.pow(2,list.size());
		List<Object> combine;
		for (long l=0L; l<n; l++) {
			combine = new ArrayList<Object>();
			for (int i=0; i<list.size(); i++) {
				if ((l>>>i&1) == 1)
					System.out.println(l+">>>"+i+"=1");
					//combine.add(list.get(i));
				else
					System.out.println(l+">>>"+i+"=0");
			}
			result.add(combine);
		}
		return result;
	}
}
