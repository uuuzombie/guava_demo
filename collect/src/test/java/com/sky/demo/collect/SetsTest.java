package com.sky.demo.collect;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

/**
 * Created by rg on 2015/7/23.
 */
public class SetsTest {

    @Test
    public void test_difference() {

        Set<Integer> set1 = Sets.newHashSet(1,2,3,4);
        Set<Integer> set2 = Sets.newHashSet(4,3,5,6);
        Set<Integer> result = Sets.difference(set1, set2);
        result.forEach(i -> System.out.println(i));
    }
}
