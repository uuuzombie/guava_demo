package com.sky.demo.cache;

import org.junit.Test;

import java.util.Date;

/**
 * Created by rg on 2015/7/15.
 */
public class CommonLoadingCacheTest {

    @Test
    public void test_get() {
        String str1 = (String) CommonLoadingCache.get("str1");
        System.out.println(str1);
    }

    @Test
    public void test_put() {

        String key = "key1";
        CommonLoadingCache.put(key,"value1");

        String str = (String) CommonLoadingCache.get(key);
        System.out.println(str);
    }


    @Test
    public void test_refresh() {

        String str1 = (String) CommonLoadingCache.get("str1");
        try {
            System.out.println(new Date());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(str1);
        System.out.println(new Date());

        try {
            System.out.println(new Date());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date());

        str1 = (String) CommonLoadingCache.get("str1");     //第二次get之后触发reload？
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str1);
    }


}
