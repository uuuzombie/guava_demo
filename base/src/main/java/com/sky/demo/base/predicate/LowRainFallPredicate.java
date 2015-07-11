package com.sky.demo.base.predicate;

import com.google.common.base.Predicate;
import com.sky.demo.base.model.City;

public class LowRainFallPredicate implements Predicate<City> {
    @Override
    public boolean apply(City input) {
        return input.getAverageRainfall() < 50;
    }
}
