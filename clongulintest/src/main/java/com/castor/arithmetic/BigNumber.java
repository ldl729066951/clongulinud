package com.castor.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 使用多线程完成数字相加求和  一亿个数字求和
 */
public class BigNumber {



  public static void main(String[] args) throws InterruptedException, ExecutionException {
  	  int size = 100000000;
  	  int[] nubmers = new int[size];
  	  for(int i=0; i<size; i++){
		  nubmers[i] = new Random().nextInt();
	  }

	  /**
	   * 单线程 begin
	   */
	  Long startAt = System.currentTimeMillis();
  	  int sum = 0;
	  for(int i=0; i<size; i++){
		  sum += nubmers[i];
	  }
	  System.out.println("sum = "+ sum + " , "+ (System.currentTimeMillis() - startAt));
	  /**
	   * 单线程 end
	   */


	  /**
	   * 多线程 begin
	   */
	  Long startAt1 = System.currentTimeMillis();
	  sum = 0;
	  ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

	  int csize = 10000000;
	  int count = size / csize;
	  CountDownLatch countDownLatch = new CountDownLatch(count);
	  List<Callable<Integer>> calls = new ArrayList<>();
	  for(int j = 0; j<count; j++){
	  	int start = j * csize;
	  	int end = (j + 1) * csize;
		  calls.add(new Task(nubmers, start, end, countDownLatch));
	  }

	  List<Future<Integer>> result = executorService.invokeAll(calls);
	  countDownLatch.await();
	  for(int k=0; k<result.size(); k++){
		  sum += result.get(k).get();
	  }

     System.out.println("sum = "+ sum + " , "+ (System.currentTimeMillis() - startAt1));
	  /**
	   * 多线程 end
	   */
  }

}

class Task implements Callable<Integer>{

	private int[] array;
	private int start;
	private int end;
	private CountDownLatch countDownLatch;

	public Task(int[] array, int start, int end, CountDownLatch countDownLatch){
		this.array = array;
		this.start = start;
		this.end = end;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=start; i< end; i++){
			sum += array[i];
		}
    	System.out.println("-----------------" +start  + "-----" + end);
		countDownLatch.countDown();
		return sum;
	}

}
