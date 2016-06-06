package com.sky.demo.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

/**
 * Created by rg on 15/7/11.
 */
public class JoinerTest {

    @Test
    public void test_Joiner(){
        int[] numbers = { 1, 2, 3, 4, 5 };
        String numbersAsString = Joiner.on("/").join(Ints.asList(numbers));

        System.out.println(numbersAsString);
    }

    @Test
    public void test_Joiner_empty_list() {
        List<Integer> list = Lists.newArrayList();
        String str = Joiner.on(",").join(list);
        System.out.println(str);
    }

    @Test
    public void test_Joiner_null() {
        List<Integer> list = null;
        String str = Joiner.on(",").join(list);
        System.out.println(str);
    }

}
