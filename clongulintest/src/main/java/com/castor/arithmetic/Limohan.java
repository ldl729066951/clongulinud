package com.castor.arithmetic;

import org.apache.xmlbeans.impl.regex.Match;

import java.util.*;
import java.util.stream.Collectors;

public class Limohan {

	private static boolean isContinus = false;

	public static void main(String[] args) {
		//List<Double> arg = Arrays.asList(1.0,2.0,3.2,15.0,16.0,17.0,35.0,100.0,200.0,300.0);
		//List<Result> res = test(arg, 33.0);
		List<Double> arg = Arrays.asList(113.61,15.2,18.96,19.9,21.12,23.88,36.67,91.31,133.45,173.7,174.0,199.0,299.0,309.0);
		List<Result> res = test(arg, 120.0);
		System.out.println("result: " +res.toString());
	}

	private static List<Result> test(List<Double> arg, Double target) {
		List<Result> res = new ArrayList<>();
		Collections.sort(arg);
		int maxSize = 0;
		double tmp = target;
		System.out.println("原序列----------------------------");
		arg.forEach(p -> System.out.print(p + " , "));
		System.out.println();
		List<Double> bigger = arg.stream().filter(p -> p > target).collect(Collectors.toList());
		System.out.println("大序列----------------------------");
		bigger.forEach(p -> System.out.print(p + " , "));
		System.out.println();
		System.out.println("小序列----------------------------");
		List<Double> smaller = arg.stream().filter(p -> p <= target).collect(Collectors.toList());
		smaller.forEach(p -> System.out.print(p + " , "));
		System.out.println();

		if(bigger != null && bigger.size() > 0){
			res.add(new Result(smaller.get(0)+bigger.get(0)-target, Arrays.asList(smaller.get(0),bigger.get(0))));
		}

		double lastSmaller = smaller.get(smaller.size() - 1);
		if(lastSmaller == target){
			smaller.stream().filter(p -> p == target).forEach(index -> res.add(new Result(0.0, Arrays.asList(index))));
			return res;
		}
		System.out.println("不存在直接满足条件的单个元素----------------------------");
		maxSize = getMaxSize(target, smaller, res);

		if(isContinus == false){
			return res;
		}

		System.out.println("流程继续--------------最大的元素个数为："+maxSize+"--------------");

		System.out.println("--------------从2开始直到元素个数为 "+maxSize+"--------------");

		for (int i= 2;i <= maxSize; i++){
			whileToEnd(i, res, smaller, target);
		}

		return res;
	}

	private static void whileToEnd(int i, List<Result> res, List<Double> smaller, double target){

		System.out.println("--------------这是元素个数为："+i+"--------------");

		for (int j = smaller.size() -1; j >0; j--){
			//if(smaller.get(j) + smaller[0])
		}


	}


	private static int getMaxSize(Double target, List<Double> smaller, List<Result> res){
		//寻找由小到大最多可以需要多少个数
		int total = 0;
		int num = 0;
		for(int i=0; i < smaller.size(); i++){
			total += smaller.get(i);
			if(total >= target){
				num = i;
				break;
			}
		}
		System.out.println("------------计算最多满足多少元素相加----------------");
		System.out.println(" total:" + total + " , num:" + num);
		System.out.println("----------------------------");
		double distance = Double.MAX_VALUE;
		if(res.size() > 0){
			distance = res.get(0).getDistance();
			System.out.println("-----------此时最小差距为："+ distance +"-----------------");
		}

		if(num == 0){
			System.out.println("------------小于target的元素的总和 <= target, 不作处理----------------");
			//putRes(total - target, distance, smaller, res);
		}else{
			System.out.println("------------小于target的元素的总和存在 >= target----------------");
			putRes(total - target, distance, smaller.subList(0, num+1), res);
			isContinus = true;
		}
		return num;
	}

	private static void putRes(double now, double distance, List<Double> list, List<Result> res){
		if(now >= 0 && now <= distance){
			if(now < distance)
				res.clear();
			res.add(new Result(now, list));
			System.out.println("-----------此时最小差距为："+ now +"-----------------");
		}
	}

}


class Result {
	private Double distance;
	private List<Double> instance;

	public Result(Double distance, List<Double> instance) {
		this.distance = distance;
		this.instance = instance;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public List<Double> getInstance() {
		return instance;
	}

	public void setInstance(List<Double> instance) {
		this.instance = instance;
	}

	@Override
	public String toString() {
		return "Result{" +
				"distance=" + distance +
				", instance=" + instance +
				'}';
	}
}