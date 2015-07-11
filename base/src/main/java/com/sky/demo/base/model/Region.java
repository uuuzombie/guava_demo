package com.sky.demo.base.model;

public enum Region {

    SOUTHWEST(1, "SOUTHWEST"),
    NORTHEAST(2, "NORTHEAST");

    private Integer index;
    private String name;

    Region(Integer index, String name) {
        this.index = index;
        this.name = name;
    }
}
