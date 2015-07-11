package com.sky.demo.base.model;

public enum Climate {

    TEMPERATE(1, "TEMPERATE"),
    SUB_TROPICAL(2, "SUB_TROPICAL");

    private Integer index;
    private String name;

    Climate(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

}
