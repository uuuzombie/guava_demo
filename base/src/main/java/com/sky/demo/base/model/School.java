package com.sky.demo.base.model;

import com.google.common.base.Objects;

/**
 * Created by rg on 15/7/12.
 */
public class School {

    private String name;
    private String location;

    private School(String name, String location) {
        this.name = name;
        this.location = location;
    }

    private static School instance;

    public static synchronized School newInstance(String name,String location){
        if (instance == null) {
            instance = new School(name,location);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("location", location)
                .toString();
    }
}
