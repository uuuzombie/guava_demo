package com.sky.demo.qua.collect;

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

        System.out.println(cityClient);


		
	}
	
}
