package com.sky.demo.qua.collect;

import org.junit.Test;
import com.sky.demo.qua.collect.CityClient.CityEntry;

public class CityClientTest {

	@Test
	public void TestGetCities(){
		
		CityEntry cityEntry = new CityEntry();
		
		CityClient cityClient = CityClient.create().cityEntry(cityEntry).build();
		
	}
	
}
