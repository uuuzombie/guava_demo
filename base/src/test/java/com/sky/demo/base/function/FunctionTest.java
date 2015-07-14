package com.sky.demo.base.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;
import com.sky.demo.base.model.State;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by rg on 15/7/12.
 */
public class FunctionTest {

    private Map<String, State> stateMap = Maps.newHashMap();

    @Before
    public void setUp(){
        stateMap.put("NewYork",new State("NewYork","001"));

    }

    @Test
    public void test_Function_forMap(){
        Function<String,State> lookup = Functions.forMap(stateMap);
        System.out.println(lookup.apply("NewYork"));
    }

    @Test
    public void test_Function_forMap_null(){
        //可以给不存在的key指定一个默认值
        Function<String,State> lookup = Functions.forMap(stateMap,null);

        System.out.println(lookup.apply("NewYork"));
        System.out.println(lookup.apply("Sin"));
    }
}
