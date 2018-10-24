package com.castor.arithmetic;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

public class Limohan {

	public static void main(String[] args) {
		List<Double> arg = Arrays.asList(1.0,2.0,3.2,15.0,16.0,17.0,35.0,100.0,200.0,300.0);
		Map<List<Double>,Double> res = test(arg, 33.3);
		
	}

	private static Map<List<Double>, Double> test(List<Double> arg, Double target) {
		Map<List<Double>, Double> res = new HashMap<>();
		Collections.sort(arg);
		arg.forEach(System.out::println);
		List<Double> bigger = arg.stream().filter(p -> p > target).collect(Collectors.toList());
		System.out.println("----------------------------");
		bigger.forEach(System.out::println);
		System.out.println("----------------------------");
		List<Double> smaller = arg.stream().filter(p -> p <= target).collect(Collectors.toList());
		smaller.forEach(System.out::println);

		if(bigger != null || bigger.size() > 0){
			res.put(Arrays.asList(smaller.get(0),bigger.get(0)),smaller.get(0)+bigger.get(0));
		}


		return null;
	}

}
