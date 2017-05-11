package com.sky.demo.concurrent.future;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by user on 17/5/11.
 */
public class ListenableFutrueDemo {

    //包装Executors创建的线程池
    private static final ListeningExecutorService listeningExecutorService =
            MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());



    public static class BusyTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return "OK";
        }
    }


    public static void processByAddListener() {
        try {
            long start = System.currentTimeMillis();
            ListenableFuture<String> listenableFuture = listeningExecutorService.submit(new BusyTask());
            System.out.println("currentThread=" + Thread.currentThread().getName());

            //法1.add listener 异步非阻塞执行任务，不会阻塞调用的线程
            listenableFuture.addListener(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("currentThread=" + Thread.currentThread().getName() +" result=" + listenableFuture.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }
            }, listeningExecutorService);
            //1.listeningExecutorService 注册callBack到原来的线程池，注意原线程如果线程执行完就关闭，则callBack执行异常
            //2.Executors.newSingleThreadExecutor() 如果CallBack是一个耗时操作，应该选择另一个线程池注册CallBack


            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            listeningExecutorService.shutdown();
        }

    }

    public static void processByAddCallBack() {
        try {
            long start = System.currentTimeMillis();
            ListenableFuture<String> listenableFuture = listeningExecutorService.submit(new BusyTask());
            System.out.println("currentThread=" + Thread.currentThread().getName());


            //法2.add callback  异步非阻塞执行任务，不会阻塞调用的线程
            Futures.addCallback(listenableFuture, new FutureCallback<String>() {
                @Override
                public void onSuccess(@Nullable String result) {
                    System.out.println("currentThread=" + Thread.currentThread().getName() + " result=" + result);
                }

                @Override
                public void onFailure(Throwable t) {
                    if (t instanceof FileNotFoundException) {
                        System.out.println("...");
                    }
                }
            });  //2.Executors.newSingleThreadExecutor() 如果CallBack是一个耗时操作，应该选择另一个线程池注册CallBack

            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            listeningExecutorService.shutdown();
        }

    }

    public static void main(String[] args) {

//        processByAddListener();

        processByAddCallBack();


    }


}
