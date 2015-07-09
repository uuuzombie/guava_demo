package com.sky.demo.qua.hash;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class HashesTest {

	@Test
	public void TestMd5(){
		
		assertEquals("881710b97e322568d6e8685aa3fbea63",Hashes.md5("sdf"));		
	}
	
	@Test
	public void TestMurmur3_32(){
		String str = Hashes.murmur3_32("sdf", 1000);
		System.out.println(str);
	}
	
}
