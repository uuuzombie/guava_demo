package com.sky.demo.base.predicate;

import com.google.common.base.Predicate;
import com.sky.demo.base.model.City;
import com.sky.demo.base.model.Climate;

public class TemperateClimatePredicate implements Predicate<City> {

    @Override
    public boolean apply(City input) {
        return input.getClimate().equals(Climate.TEMPERATE);
    }
}
