package com.sky.demo.concurrent.future;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by user on 17/5/11.
 */
public class FutureVsListenableFuture {

    private static final ListeningExecutorService LISTENING_EXECUTOR_SERVICE =
            MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());


    public static class MyTask1 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("Task1 start");
            Thread.sleep(1000);
            System.out.println("Task1 end");
            return new Random().nextInt();
        }
    }

    public static class MyTask2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Task2 start");
            Thread.sleep(2000);
            System.out.println("Task2 end");

            return String.valueOf(new Random().nextFloat());
        }
    }

    public static class MyTask3 implements Callable<Long>{

        @Override
        public Long call() throws Exception {
            System.out.println("Task3 start");
            Thread.sleep(3000);
            System.out.println("Task3 end");

            return new Random().nextLong();
        }
    }


    //异步阻塞，半异步，并发请求多任务，总耗时为最长任务的响应时间;
    public static void processByFuture() {

        try {
            long start = System.currentTimeMillis();
            Future<Integer> future1 = LISTENING_EXECUTOR_SERVICE.submit(new MyTask1());
            Future<String> future2 = LISTENING_EXECUTOR_SERVICE.submit(new MyTask2());
            Future<Long> future3 = LISTENING_EXECUTOR_SERVICE.submit(new MyTask3());

            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());

            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + "ms");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            LISTENING_EXECUTOR_SERVICE.shutdown();
        }
    }

    //异步非阻塞
    public static void processByListenableFuture() {

        try {
            long start = System.currentTimeMillis();

            ListenableFuture<Integer> future1 = LISTENING_EXECUTOR_SERVICE.submit(new MyTask1());
            ListenableFuture<String> future2 = LISTENING_EXECUTOR_SERVICE.submit(new MyTask2());
            ListenableFuture<Long> future3 = LISTENING_EXECUTOR_SERVICE.submit(new MyTask3());


            Futures.addCallback(future1, new FutureCallback<Integer>() {
                @Override
                public void onSuccess(@Nullable Integer result) {
                    System.out.println(result);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

            Futures.addCallback(future2, new FutureCallback<String>() {
                @Override
                public void onSuccess(@Nullable String result) {
                    System.out.println(result);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

            Futures.addCallback(future3, new FutureCallback<Long>() {
                @Override
                public void onSuccess(@Nullable Long result) {
                    System.out.println(result);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LISTENING_EXECUTOR_SERVICE.shutdown();
        }


    }

    public static void main(String[] args) {
//        processByFuture();

        processByListenableFuture();

    }
}
