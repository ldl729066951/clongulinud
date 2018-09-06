package com.castor;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private Integer age;
	private Integer score;

	public static void main(String[] args) {

		List<Main> lists = new ArrayList<>();
		lists.add(new Main(2, 50));
		lists.add(new Main(1, 50));
		lists.add(new Main(3, 60));

		lists.stream().sorted((a , b) -> {
			if(a.score > b.score )
				return -1;
			else if(a.score < b.score )
				return 1;
			else{
				if(a.age > b.age)
					return 1;
				else if(a.age < b.age)
					return -1;
				else return 0;
			}
		}).forEach(System.out::println);

	}

	public Main(Integer age, Integer score) {
		this.age = age;
		this.score = score;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Main{" +
				"age=" + age +
				", score=" + score +
				'}';
	}
}
