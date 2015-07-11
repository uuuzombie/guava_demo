package com.sky.demo.base.model;

public class City {

    private String name;

    private String zipCode;

    private Integer population;

    private Climate climate;

    private Double averageRainfall;


    public City(String name, String zipCode, Integer population, Climate climate, Double averageRainfall) {
        this.name = name;
        this.zipCode = zipCode;
        this.population = population;
        this.climate = climate;
        this.averageRainfall = averageRainfall;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public Double getAverageRainfall() {
        return averageRainfall;
    }

    public void setAverageRainfall(Double averageRainfall) {
        this.averageRainfall = averageRainfall;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", population=" + population +
                ", climate='" + climate + '\'' +
                ", averageRainfall=" + averageRainfall +
                '}';
    }

}
