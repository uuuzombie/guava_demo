package com.sky.demo.qua.collect;

import com.google.common.base.*;
import com.google.common.collect.*;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * CityClient is used to query information about a city.
 * 
 * <p>
 * A city can be identified by either a cityId or a cityUrl, and both of them are overall unique. Every city belongs to
 * a single province, i.e. there is an one to many relationship between provinces and cites
 * </p>
 * 
 * @author sy
 */
@Exercise(name = "CityClient", difficulty = Difficulty.NORMAL, related = { Multimap.class, BiMap.class })
public class CityClient {

	private ListMultimap<Province, City> provinceCityListMultimap;  // = ArrayListMultimap.create();
	
    public static Builder create() {
        return new Builder();
    }

    //builder 模式
    private CityClient(Builder builder) {
        // TODO implement this;
    	this.provinceCityListMultimap = builder.map;
    }

    /**
     * get all cities under an province identified by the given provinceId
     * @param provinceId used to identify the target province
     * @return the set of cities in the target province, or empty city if the target province doesn't exist
     */
    public ImmutableSet<City> getCities(int provinceId) {
        // TODO implement this

//        Collection<Province> provinces = Collections2.filter(provinceCityListMultimap.keySet(), new Predicate<Province>() {
//            @Override
//            public boolean apply(@Nullable Province input) {
//                return input.getProvinceId() == provinceId;
//            }
//        });

        Set<Province> provinces = provinceCityListMultimap.keySet().stream().filter(new java.util.function.Predicate<Province>() {
            @Override
            public boolean test(Province province) {
                return province.getProvinceId() == provinceId;
            }
        }).collect(Collectors.toSet());

        ImmutableSet<City> immutableSet = null;
        if (CollectionUtils.isNotEmpty(provinces)) {
            Collection<City> cityList = provinceCityListMultimap.asMap().get(provinces.iterator().next());

            immutableSet = ImmutableSet.copyOf(cityList);
        }
        return immutableSet;
    }

    /**
     * get all provinces in the CityClient
     */
    public ImmutableSet<Province> getProvinces() {
        // TODO implement this
        ImmutableSet<Province> immutableSet = ImmutableSet.copyOf(provinceCityListMultimap.keySet());
        return immutableSet;
    }

    /**
     * query for the province a city belonging to
     * @param cityId the id used to identify the city
     * @return the province that contains the city, or null if the city doesn't exist
     */
    public Province getProvinceFor(int cityId) {
        // TODO implement this

        return null;
    }

    /**
     * find a province by its id
     * @param provinceId the id used to query Province
     * @return the target province or null
     */
    public Province getProvince(int provinceId) {
        // TODO implement this
        Set<Province> provinces = (HashSet<Province>)provinceCityListMultimap.keySet().stream().filter(new java.util.function.Predicate<Province>() {
            @Override
            public boolean test(Province province) {
                return province.getProvinceId() == provinceId;
            }
        }).collect(Collectors.toSet());

        return CollectionUtils.isEmpty(provinces) ? null : provinces.iterator().next();
    }

    /**
     * find a city by its id
     */
    public City getCity(int cityId) {
        // TODO implement this
        Set<City> cities = provinceCityListMultimap.values().stream().filter(new java.util.function.Predicate<City>() {
            @Override
            public boolean test(City city) {
                return city.getCityId() == cityId;
            }
        }).collect(Collectors.toSet());

        return CollectionUtils.isEmpty(cities) ? null : cities.iterator().next();
    }

    /**
     * get corresponding cityUrl for a cityId
     * @return the corresponding cityUrl or null if not exists
     */
    public String getCityUrlFor(int cityId) {
        // TODO implement this
        City city = getCity(cityId);
        String url = city == null ? null : city.getCityUrl();
        return url;
    }

    /**
     * get corresponding cityId for a city
     * @return the corresponding cityId or null if not exists
     */
    public int getCityIdFor(String cityUrl) {
        // TODO implement this

        Set<City> cities = provinceCityListMultimap.values().stream().filter(new java.util.function.Predicate<City>() {
            @Override
            public boolean test(City city) {
                return StringUtils.equals(cityUrl, city.getCityUrl());
            }
        }).collect(Collectors.toSet());

        int id = 0;
        if (CollectionUtils.isNotEmpty(cities)) {
            id = cities.iterator().next().getCityId();
        }
        return id;
    }


    public final static class Builder {

    	private ListMultimap<Province, City> map = ArrayListMultimap.create();
    	
    	
        private Builder() {
        }

        public Builder cityEntry(CityEntry cityEntry) {
            // TODO implement this
        	City city = new City(cityEntry.getCityId(), cityEntry.getCityUrl(), cityEntry.getCityName());
        	Province province = new Province(cityEntry.getProvinceId(), cityEntry.getProvinceName());
        	map.put(province, city);
            return this;
        }

        public Builder cityEntries(Iterable<CityEntry> cityEntries) {
            // TODO implement this
        	for (CityEntry cityEntry : cityEntries) {
        		cityEntry(cityEntry);
			}
            return this;
        }

        public CityClient build() {
            return new CityClient(this);
        }
    }

    public static class CityEntry {

        private int provinceId;
        private String provinceName;
        private int cityId;
        private String cityUrl;
        private String cityName;

        public CityEntry(int provinceId, String provinceName, int cityId, String cityUrl, String cityName) {
            this.provinceId = provinceId;
            this.provinceName = provinceName;
            this.cityId = cityId;
            this.cityUrl = cityUrl;
            this.cityName = cityName;
        }

        public CityEntry() {
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityUrl() {
            return cityUrl;
        }

        public void setCityUrl(String cityUrl) {
            this.cityUrl = cityUrl;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("provinceId", provinceId)
                    .add("provinceName", provinceName)
                    .add("cityId", cityId)
                    .add("cityUrl", cityUrl)
                    .add("cityName", cityName)
                    .toString();
        }
    }

    public static class City {

        private final int cityId;
        private final String cityUrl;
        private final String name;

        public City(int cityId, String cityUrl, String name) {
            this.cityId = cityId;
            this.cityUrl = cityUrl;
            this.name = name;
        }

        public int getCityId() {
            return cityId;
        }

        public String getCityUrl() {
            return cityUrl;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof City))
                return false;

            City city = (City) o;

            if (cityId != city.cityId)
                return false;
            if (cityUrl != null ? !cityUrl.equals(city.cityUrl) : city.cityUrl != null)
                return false;
            if (name != null ? !name.equals(city.name) : city.name != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = cityId;
            result = 31 * result + (cityUrl != null ? cityUrl.hashCode() : 0);
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("cityId", cityId)
                    .add("cityUrl", cityUrl)
                    .add("name", name)
                    .toString();
        }
    }

    public static class Province {

        private final int provinceId;
        private final String name;

        public Province(int provinceId, String name) {
            this.provinceId = provinceId;
            this.name = name;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Province))
                return false;

            Province province = (Province) o;

            if (provinceId != province.provinceId)
                return false;
            if (name != null ? !name.equals(province.name) : province.name != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = provinceId;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("provinceId", provinceId)
                    .add("name", name).toString();
        }
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("provinceCityListMultimap", provinceCityListMultimap)
                .toString();
    }
}
