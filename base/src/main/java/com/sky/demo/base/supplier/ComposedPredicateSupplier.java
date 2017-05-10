package com.sky.demo.base.supplier;


import com.google.common.base.*;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sky.demo.base.model.City;
import com.sky.demo.base.model.Climate;
import com.sky.demo.base.model.Region;
import com.sky.demo.base.model.State;

import java.util.Map;

public class ComposedPredicateSupplier implements Supplier<Predicate<String>> {

    @Override
    public Predicate<String> get() {

        City city = new City("Austin,TX","12345",250000, Climate.SUB_TROPICAL, 45.3);
        State state = new State("Texas","TX", Sets.newHashSet(city), Region.SOUTHWEST);

        City city1 = new City("New York,NY","12345",2000000,Climate.TEMPERATE, 48.7);
        State state1 = new State("New York","NY",Sets.newHashSet(city1), Region.NORTHEAST);

        Map<String,State> stateMap = Maps.newHashMap();
        stateMap.put(state.getCode(),state);
        stateMap.put(state1.getCode(),state1);

        Function<String,State> mf = Functions.forMap(stateMap);
        return Predicates.compose(new RegionPredicate(), mf);
    }

    
}
