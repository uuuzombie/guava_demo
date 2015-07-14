package com.sky.demo.base.function;

import com.google.common.base.Function;

import javax.annotation.Nullable;

/**
 * Created by rg on 15/7/12.
 */
public class PriceUtil {

    public static Function<Double, Double> transfer = new Function<Double, Double>() {
        double eurTouUsd = 1.4888;

        @Nullable
        @Override
        public Double apply(@Nullable Double input) {
            return input * eurTouUsd;
        }
    };


}
