package com.sky.demo.base.supplier;


import com.google.common.base.Predicate;
import com.sky.demo.base.model.Region;
import com.sky.demo.base.model.State;

public class RegionPredicate implements Predicate<State> {

    @Override
    public boolean apply(State input) {
        return input.getRegion().equals(Region.NORTHEAST);
    }
}
