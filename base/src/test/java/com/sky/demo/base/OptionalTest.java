package com.sky.demo.base;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rg on 15/7/11.
 */
public class OptionalTest {

    @Test
    public void test_Optional_not_null(){
        Optional<Integer> opt = Optional.of(5);

        assertTrue(opt.isPresent());
        System.out.println("opt value is " + opt.get());
    }

    @Test
    public void test_Optional_absent(){
        Optional<Integer> opt = Optional.absent();

        assertTrue(!opt.isPresent());
    }

    @Test
    public void test_Optional_fromNullable_null(){
        Optional<Integer> opt = Optional.fromNullable(null);

        assertTrue(!opt.isPresent());

    }

    @Test
    public void test_Optional_fromNullable_not_null(){
        Optional<Integer> opt = Optional.fromNullable(4);

        assertTrue(opt.isPresent());
        System.out.println(opt.get());
    }
}
