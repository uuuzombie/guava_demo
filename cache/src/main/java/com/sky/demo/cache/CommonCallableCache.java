package com.sky.demo.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by rg on 2015/7/15.
 */
public class CommonCallableCache {

    private static final Cache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(1000).build();

    public static Object get(String key) {
        Object value = null;
        try {
            value = cache.get(key, new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return "from cache :" + key;
                }
            });
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
}
