package com.sky.demo.base.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Set;

public class State {

    private String name;
    private String code;
    private Set<City> mainCities = Sets.newHashSet();
    private Region region;

    public State(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public State(String name, String code, Set<City> mainCities, Region region) {
        this.name = name;
        this.code = code;
        this.mainCities = mainCities;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<City> getMainCities() {
        return mainCities;
    }

    public void setMainCities(Set<City> mainCities) {
        this.mainCities = mainCities;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("code", code)
                .add("mainCities", mainCities)
                .add("region", region)
                .toString();
    }
}
