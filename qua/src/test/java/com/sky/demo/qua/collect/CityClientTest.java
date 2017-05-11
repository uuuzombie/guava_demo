package com.sky.demo.qua.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import com.sky.demo.qua.collect.CityClient.CityEntry;

public class CityClientTest {

    private CityClient cityClient;

    @Before
    public void setUp() {
        CityEntry cityEntry1 = new CityEntry(1, "Hebei", 101, "sjz", "shijiazhuang");
        CityEntry cityEntry2 = new CityEntry(1, "Hebei", 102, "xt", "xingtai");
        CityEntry cityEntry3 = new CityEntry(2, "Beijing", 201, "bj", "beijing");
        CityEntry cityEntry4 = new CityEntry(3, "shandong", 301, "jn", "jinan");


        cityClient = CityClient.create()
                .cityEntry(cityEntry1)
                .cityEntry(cityEntry2)
                .cityEntries(Lists.newArrayList(cityEntry3, cityEntry4))
                .build();


    }

	@Test
	public void test_getCities(){
        int provinceId = 1;
        ImmutableSet<CityClient.City> cities = cityClient.getCities(provinceId);
        System.out.println(cities);
	}

    @Test
    public void test_getProvinces() {
        ImmutableSet<CityClient.Province> provinces = cityClient.getProvinces();
        System.out.println(provinces);
    }

    @Test
    public void test_getProvinceFor() {
        //TODO
    }

    @Test
    public void test_getProvinceById() {
        int provinceId = 2;
        CityClient.Province province = cityClient.getProvince(provinceId);
        System.out.println(province);
    }

    @Test
    public void test_getCity() {
        int cityId = 101;
        CityClient.City city = cityClient.getCity(cityId);
        System.out.println(city);
    }

    @Test
    public void test_getCityUrlFor() {
        int cityId = 101;
        String url = cityClient.getCityUrlFor(cityId);
        System.out.println(url);
    }

    @Test
    public void test_getCityIdFor() {
        String url = "sjz";
        int cityId = cityClient.getCityIdFor(url);
        System.out.println(cityId);

    }

}
