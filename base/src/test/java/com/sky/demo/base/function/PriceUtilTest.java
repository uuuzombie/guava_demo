package com.sky.demo.base.function;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class PriceUtilTest {

    Map<String,Double> eur = Maps.newHashMap();

    @Before
    public void setUp(){

        for (int i = 0;i < 5;++i){
            eur.put("product" + i, 1.2 + i);
        }
    }

    //欧元转美元
    @Test
    public void test_Function(){

        System.out.println(eur);

        Map<String,Double> usd = Maps.transformValues(eur,new Function<Double,Double>() {
            double eurTouUsd = 1.4888;

            @Override
            public Double apply(Double input) {
                return input * eurTouUsd;
            }
        });

        System.out.println(eur);
        System.out.println(usd);
    }

    @Test
    public void test_Function_by_static_var(){
        System.out.println(eur);

        Map<String,Double> usd = Maps.transformValues(eur , PriceUtil.transfer);

        System.out.println(usd);
    }
}
