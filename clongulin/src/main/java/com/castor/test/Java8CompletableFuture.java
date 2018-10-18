package com.castor.test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Java8CompletableFuture {

    public static void main(String[] args) throws Exception {


        /*completedFutureExample();

        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenAccept(res -> {
            System.out.println(res.toUpperCase());
        });

        System.out.println("doing....");*/

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Java8CompletableFuture::getMoreData);
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });
        System.out.println(f.get());
        System.in.read();



        Thread.sleep(20000);
    }

    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();
    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
        return rand.nextInt(1000);
    }


    static void completedFutureExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        //assertTrue(cf.isDone());
        //assertEquals("message", cf.getNow(null));
        if(cf.isDone()){
            String msg = cf.getNow(null) == "message" ? "yes" : "no";
            System.out.println(msg);
        }
    }

    static String asyncMethod(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }


}
