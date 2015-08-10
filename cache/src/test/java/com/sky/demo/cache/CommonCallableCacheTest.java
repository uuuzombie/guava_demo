package com.sky.demo.cache;

import org.junit.Test;

/**
 * Created by rg on 2015/7/15.
 */
public class CommonCallableCacheTest {

    @Test
    public void test_get() {

        String value = (String) CommonCallableCache.get("key1");
        System.out.println(value);

    }

    @Test
    public void test_put() {
        String key = "key1";
        CommonCallableCache.put(key,"value1");

        String value = (String) CommonCallableCache.get(key);
        System.out.println(value);
    }
}
