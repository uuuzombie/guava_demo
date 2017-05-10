package com.sky.demo.base.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sky.demo.base.model.City;
import com.sky.demo.base.model.Climate;
import com.sky.demo.base.model.Region;
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
        City city1 = new City("city1","code1",5000, Climate.SUB_TROPICAL,20.0);
        City city2 = new City("city2","code2",10000, Climate.TEMPERATE,30.0);
        City city3 = new City("city3","code3",15000, Climate.SUB_TROPICAL,60.0);
        City city4 = new City("city4","code4",5000, Climate.TEMPERATE,70.0);


        stateMap.put("NewYork",new State("NewYork","001", Sets.newHashSet(city1, city2), Region.NORTHEAST));
        stateMap.put("Beijing", new State("Beijing", "002", Sets.newHashSet(city3), Region.NORTHEAST));
        stateMap.put("Shanghai",new State("Shanghai","003", Sets.newHashSet(city4), Region.SOUTHWEST));

    }

    @Test
    public void test_Function_forMap(){
        Function<String, State> lookup = Functions.forMap(stateMap);  //返回映射关系
        System.out.println(lookup.apply("NewYork"));
    }

    @Test
    public void test_Function_forMap_null(){
        //可以给不存在的key指定一个默认值
        Function<String,State> lookup = Functions.forMap(stateMap, null);

        System.out.println(lookup.apply("NewYork"));
        System.out.println(lookup.apply("Sin"));
    }

    @Test
    public void test_Function_compose() {
        Function<String, State> lookup = Functions.forMap(stateMap);
        Function<State, String> stateFunction = new StateToCityString();

        //可以理解为第二个参数的输入参数就是composed.apply方法的输入参数，第一个参数的输出就是composed.apply方法的输出。
        Function<String, String> composed = Functions.compose(stateFunction, lookup);  //组合
        String cities = composed.apply("NewYork");
        System.out.println(cities);

        //or equals
        cities = stateFunction.apply(lookup.apply("NewYork"));
        System.out.println(cities);
    }
}
