package com.sky.demo.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by rg on 2015/7/15.
 */
public class CommonLoadingCache {

    //LoadingCache is thread-safe
    private static final LoadingCache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(100)
            .refreshAfterWrite(2, TimeUnit.SECONDS).build(new CacheLoader<String, Object>() {
                @Override
                public Object load(String s) throws Exception {
                    return "from cache : " + s;
                }

                // 可实现异步reload
                @Override
                public ListenableFuture<Object> reload(String key, Object oldValue) throws Exception {
                    System.out.println("reload : " + new Date());
                    return super.reload(key, oldValue);
                }

            });

    public static Object get(String key) {
        Object value = null;
        try {
            value = cache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void put(String key, Object value) {
        try {
            cache.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        String str1 = (String) CommonLoadingCache.get("str1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str1);
    }
}
