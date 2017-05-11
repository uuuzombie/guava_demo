package com.sky.demo.concurrent.executor;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

/**
 * Created by user on 17/5/11.
 */
public class AsyncWorker<T> {

    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 50;
    private static final int MAX_QUEUE_SIZE = 100;
    private static final int KEEP_ALIVE_TIME = 3000;

    private static final ListeningExecutorService EXECUTORS = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(MAX_QUEUE_SIZE),
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("reject");
                }
            }
    ));


    public static void execute(final Runnable runnable) {
        EXECUTORS.execute(runnable);
    }

    public static <T> ListenableFuture<T> submit(final Callable<T> callable) {
        return EXECUTORS.submit(callable);
    }

    public static void shutdown() {
        EXECUTORS.shutdown();
    }
}
