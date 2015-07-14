package com.sky.demo.collect;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by rg on 15/7/11.
 */
public class IterablesTest {

    List<Integer> list = Lists.newArrayList();

    @Before
    public void setUp(){
        list = Arrays.asList(1, 2, 3, 4, 1024);
    }

    @Test
    public void test_Iterables_any_Predicate(){
        Iterator<Integer> iterator = list.iterator();
        //判断一个List中是否有某个数
        boolean isExist = Iterables.any(list, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input == 1024;
            }
        });

        assertTrue(isExist == true);
    }

    @Test
    public void test_Iterables_transform(){
        Iterable<Integer> result = Iterables.transform(list,new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                return input * input;
            }
        });

        System.out.println(list);
        System.out.println(result);
    }

    @Test
    public void test_Iterables_filter(){
        Iterable<Integer> result = Iterables.filter(list, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input % 2 == 0;
            }
        });
        System.out.println(list);
        System.out.println(result);
    }
}
