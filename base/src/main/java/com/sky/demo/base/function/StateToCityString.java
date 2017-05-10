package com.sky.demo.base.function;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.sky.demo.base.model.State;

import javax.annotation.Nullable;

/**
 * Created by user on 17/5/10.
 */
public class StateToCityString implements Function<State, String> {

    @Nullable
    @Override
    public String apply(@Nullable State input) {
        return Joiner.on(",").skipNulls().join(input.getMainCities());
    }
}
