package com.sky.demo.base;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;
import org.junit.Test;

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
}
