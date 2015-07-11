package com.sky.demo.base.predicate;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sky.demo.base.model.City;
import com.sky.demo.base.model.Climate;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by rg on 15/7/11.
 */
public class PredicateTest {

    private List<City> cityList = Lists.newArrayList();

    private Map<String,City> cityMap = Maps.newHashMap();

    @Before
    public void setUp(){
        City city1 = new City("city1","code1",5000, Climate.SUB_TROPICAL,20.0);
        City city2 = new City("city2","code2",10000, Climate.TEMPERATE,30.0);
        City city3 = new City("city3","code3",15000, Climate.SUB_TROPICAL,60.0);
        City city4 = new City("city4","code4",5000, Climate.TEMPERATE,70.0);

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);

        cityMap.put(city1.getName(),city1);
        cityMap.put(city2.getName(),city2);
        cityMap.put(city3.getName(),city3);
        cityMap.put(city4.getName(),city4);
    }

    @Test
    public void test_Predicate_and(){
        Predicate<City> smallAndDry = Predicates.and(new SmallPopulationPredicate(), new LowRainFallPredicate());
        Collection<City> cityCollection = Collections2.filter(cityList, smallAndDry);

        System.out.println(cityCollection);
    }

    @Test
    public void test_Predicate_or(){
        Predicate<City> smallOrDry = Predicates.or(new SmallPopulationPredicate(),new LowRainFallPredicate());
        Collection<City> cityCollection = Collections2.filter(cityList,smallOrDry);

        System.out.println(cityCollection);
    }

    @Test
    public void test_Predicate_not(){
        Predicate notDry = Predicates.not(new LowRainFallPredicate());
        Collection<City> cities = Collections2.filter(cityList,notDry);

        System.out.println(cities);
    }

    @Test
    public void test_Predicate_compose(){
        List<String> list = Lists.transform(cityList, new Function<City, String>() {
            @Override
            public String apply(City input) {
                return input.getName();
            }
        });
        System.out.println("list:" + list);

        Predicate<String> pre = Predicates.compose(new SmallPopulationPredicate(), Functions.forMap(cityMap));
        Collection<String> cities = Collections2.filter(list,pre);
        System.out.println(cities);
    }
}
