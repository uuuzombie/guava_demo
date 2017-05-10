package com.sky.demo.qua.base;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class StringInflectTest {

	@Test
	public void test_camelize(){
		assertEquals("UnderScore",StringInflect.camelize("under_score", true));
		assertEquals("underScore",StringInflect.camelize("under_score", false));
//		assertEquals(null, StringInflect.camelize(null, false));
	}
	
	@Test
	public void test_dasherize(){
		assertEquals("an-example", StringInflect.dasherize("an_example"));
//		assertEquals(null, StringInflect.dasherize(null));
	}
	
	@Test
	public void test_underscore(){
		assertEquals("camel_case",StringInflect.underscore("CamelCase"));
		//assertEquals(null, StringInflect.underscore(null));
	}
	
}
