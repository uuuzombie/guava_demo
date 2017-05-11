package com.sky.demo.concurrent.future;

import java.util.concurrent.*;

/**
 * Created by user on 17/5/11.
 */
public class FutureDemo {

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void shudown() {
        executor.shutdown();
    }

    public static class BusyTask implements Callable<String> {

        @Override
        public String call() throws Exception {

            Thread.sleep(2000);
            return "OK";
        }
    }


    public static void process() {
        try {
            long start = System.currentTimeMillis();
            Future<String> future = executor.submit(new BusyTask());

            //使用isDone方法检查计算是否完成
            while (!future.isDone() && !future.isCancelled()) {

            }

            //使用get阻塞住调用线程，直到计算完成返回结果
            String result = future.get();


            long end = System.currentTimeMillis();
            System.out.println("take time: " + (end - start) + " ms");
            System.out.println("result = " + result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) {

        process();

    }
}
