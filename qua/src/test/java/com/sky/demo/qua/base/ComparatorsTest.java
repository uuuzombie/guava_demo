package com.sky.demo.qua.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.sky.demo.qua.base.Comparators.LongComparator;
import com.sky.demo.qua.base.Comparators.LongHolder;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ComparatorsTest {

	private LongHolder param1;
	private LongHolder param2;

	private int expected;
	
	//private static LongComparator longComparator = new LongComparator();
	
	public ComparatorsTest(int param1,int param2,int expected) {
		this.param1 = new LongHolder(param1);
		this.param2 = new LongHolder(param2);
		this.expected = expected;
	}
	
	@Parameters  //need @RunWith(Parameterized.class)
	public static Collection prepareData(){
		Object[][] object = {
				{123, 123, 0},
				{1, 2, -1},
				{2, 1, 1}
		};
		return Arrays.asList(object);
	}
	
	
	@Test
	public void test_Compare() {
		
		/*
		LongHolder longHolder1 = new LongHolder(123);
		LongHolder longHolder2 = new LongHolder(123);

		LongComparator longComparator = new LongComparator();
		assertEquals(0, longComparator.compare(longHolder1, longHolder2));
		*/
		
		LongComparator longComparator = new LongComparator();
		int result = longComparator.compare(param1, param2);
		assertEquals(expected, result);
	}

}
