package com.sky.demo.base;

import com.google.common.base.CharMatcher;
import org.junit.Test;

/**
 * Created by rg on 15/7/11.
 */
public class CharMatcherTest {

    @Test
    public void test_matchesAllOf(){
        String str = "";
        if (CharMatcher.DIGIT.matchesAllOf(str)){
            System.out.println("match");
        }
    }
}
