package com.castor.arithmetic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test{

	/*public static void main(String[] args){
			String[] array=new String[]{ "1","2","3","4"};
			listAll(Arrays.asList(array),"");
	}

	public static void listAll(List cadidate, String prefix){
		System.out.println(prefix);
		for(int i=0;i<cadidate.size();i++){
			List temp = new LinkedList(cadidate);
			listAll(temp,prefix+temp.remove(i));  //temp是删后的列表， remove 是LinkedList所拥有的方法。
		}
	}*/

	private static List<Integer> arrays =  Arrays.asList(1,2,3,4,5,6,7,8,9,10);

	public static void main(String[] args) {
		combine(arrays.size(), 6, "");
	}

	/*private static void combine(int cabSize, int getSize, int str){
		for(int i = cabSize; i >= getSize; i--){
			if(getSize > 1){
				combine(i-1, getSize - 1, str+arrays.get(i-1));
			}else{
				System.out.println( str + arrays.get(i - 1));
			}
			System.out.println("-------------------------");
		}
	}*/



	private static void combine(int cabSize, int getSize, String str){
		for(int i = cabSize; i >= getSize; i--){
			if(getSize > 1){
				combine(i-1, getSize - 1, str+arrays.get(i-1));
			}else{
				System.out.print( str + arrays.get(i - 1));
			}
			System.out.println();
		}
	}

}