package com.sky.demo.cache;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by rg on 2015/7/15.
 */
public class CommonCache {

    private static final Map<String, Object> cache = Maps.newConcurrentMap();

    static {
        cache.put("key","value");
    }

    public static Object get(String key) {
        return cache.get(key);
    }

    public static void put(String key, Object value) {
        cache.put(key, value);
    }
}
