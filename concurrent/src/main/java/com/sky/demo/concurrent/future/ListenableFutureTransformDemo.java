package com.sky.demo.concurrent.future;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by user on 17/5/11.
 */
public class ListenableFutureTransformDemo {

    private static final ListeningExecutorService listeningExecutorService =
            MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());



    public static class Task1 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("Task1 start");
            Thread.sleep(1000);
            System.out.println("Task1 end");

            return new Random().nextInt();
        }
    }

    public static class Task2 implements Callable<String> {

        private Integer value;

        public Task2(Integer value) {
            this.value = value;
        }

        @Override
        public String call() throws Exception {
            System.out.println("Task2 start");
            Thread.sleep(2000);
            System.out.println("Task2 end");

            return value + "_xxx";
        }
    }


    public static void process() {

        try {
            long start = System.currentTimeMillis();
            ListenableFuture<Integer> future1 = listeningExecutorService.submit(new Task1());

            AsyncFunction<Integer, String> asyncFunction = new AsyncFunction<Integer, String>() {
                @Override
                public ListenableFuture<String> apply(Integer input) throws Exception {
                    return listeningExecutorService.submit(new Task2(input));
                }
            };

            ListenableFuture<String> future2 = Futures.transform(future1, asyncFunction);

            String result = future2.get();  //阻塞线程
            System.out.println(result);

            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + "ms");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            listeningExecutorService.shutdown();
        }

    }


    public static void main(String[] args) {

        process();
    }
}
