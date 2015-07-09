package com.sky.demo.qua.base;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

//@RunWith(Parameterized.class)
public class ExplosiveStringUtilsTest {

	//@Ignore
	@Test
	public void test_AllNumeric(){
		assertEquals(true,ExplosiveStringUtils.allNumeric("1233446"));
		assertEquals(false,ExplosiveStringUtils.allNumeric("12qw"));
		assertEquals(true,ExplosiveStringUtils.allNumeric(""));
		assertEquals(false,ExplosiveStringUtils.allNumeric(null));
	}

	//@Ignore
	@Test
	public void test_IsAnSerialNumber(){
		assertEquals(true, ExplosiveStringUtils.isAnSerialNumber("123-123-3"));
		assertEquals(false, ExplosiveStringUtils.isAnSerialNumber("123-w-3"));
		assertEquals(true, ExplosiveStringUtils.isAnSerialNumber(""));
		assertEquals(false, ExplosiveStringUtils.isAnSerialNumber(null));
	}
	
	//@Ignore
	@Test
	public void test_ContainsWhitespace(){
		assertEquals(false, ExplosiveStringUtils.containsWhitespace("1233446"));
		assertEquals(true, ExplosiveStringUtils.containsWhitespace("12 qw"));
		assertEquals(false, ExplosiveStringUtils.containsWhitespace(""));
		assertEquals(true, ExplosiveStringUtils.containsWhitespace("123 123 3"));
		assertEquals(true, ExplosiveStringUtils.containsWhitespace("123 w 123"));
	}	
	
	//@Ignore
	@Test
	public void test_TrimWhitespace(){
		assertEquals("123", ExplosiveStringUtils.trimWhitespace("  123 "));
		assertEquals("123", ExplosiveStringUtils.trimWhitespace("123 "));
		assertEquals("123", ExplosiveStringUtils.trimWhitespace("  123"));
		assertEquals("123", ExplosiveStringUtils.trimWhitespace("123"));
		assertEquals("123", ExplosiveStringUtils.trimWhitespace("  123 "));
		assertEquals(null, ExplosiveStringUtils.trimWhitespace(null));

	}
		
	//@Ignore
	@Test
	public void test_TrimAllWhitespace(){
		assertEquals("123", ExplosiveStringUtils.trimAllWhitespace("  123 "));
		assertEquals("123", ExplosiveStringUtils.trimAllWhitespace("123 "));
		assertEquals("123", ExplosiveStringUtils.trimAllWhitespace("123"));
		assertEquals("123", ExplosiveStringUtils.trimAllWhitespace("1 23"));
		assertEquals("123", ExplosiveStringUtils.trimAllWhitespace("1 2 3"));
		assertEquals("123", ExplosiveStringUtils.trimAllWhitespace(" 12 3 "));
		assertEquals(null, ExplosiveStringUtils.trimAllWhitespace(null));
	}
	
	//@Ignore
	@Test
	public void test_TrimLeadingWhitespace(){
		assertEquals("123 ", ExplosiveStringUtils.trimLeadingWhitespace("  123 "));
		assertEquals("123 ", ExplosiveStringUtils.trimLeadingWhitespace("123 "));
		assertEquals("123", ExplosiveStringUtils.trimLeadingWhitespace("  123"));
		assertEquals("123", ExplosiveStringUtils.trimLeadingWhitespace("123"));
		assertEquals(null, ExplosiveStringUtils.trimLeadingWhitespace(null));
	}
	
	//@Ignore
	@Test
	public void test_TrimTrailingWhitespace(){
		assertEquals("  123", ExplosiveStringUtils.trimTrailingWhitespace("  123 "));
		assertEquals("123", ExplosiveStringUtils.trimTrailingWhitespace("123 "));
		assertEquals("  123", ExplosiveStringUtils.trimTrailingWhitespace("  123"));
		assertEquals("123", ExplosiveStringUtils.trimTrailingWhitespace("123"));
		assertEquals(null, ExplosiveStringUtils.trimTrailingWhitespace(null));
	}
	
	//@Ignore
	@Test
	public void test_RetainAllAsciiAndDigit(){
		
		assertEquals("FirstName LastName  +1 123 456 789 !@#$%^", ExplosiveStringUtils.retainAllAsciiAndDigit("FirstName LastName 中国人 +1 123 456 789 !@#$%^"));
		assertEquals(null, ExplosiveStringUtils.trimTrailingWhitespace(null));
	}
	
	//@Ignore
	@Test
	public void test_Join(){
		List<String> listStrings = Arrays.asList("123","456","789");
		
		assertEquals("123-456-789",ExplosiveStringUtils.join(listStrings, "-"));
		assertEquals("123456789",ExplosiveStringUtils.join(listStrings, ""));
		//assertEquals("123456789",ExplosiveStringUtils.join(listStrings, null));
		//assertEquals(null,ExplosiveStringUtils.join(null, ","));
	}

	@Test
	public void test_JoinAndIgnoreNull(){
		List<String> listStrings = Arrays.asList("12","34",null,"56");
		//ImmutableList<String> listStrings = ImmutableList.of("12","34",null,"56");

		assertEquals("12-34-56", ExplosiveStringUtils.joinAndIgnoreNull(listStrings, "-"));
	}
	
	@Test
	public void test_TrimAndCollapseAllNonAsciiWith(){
		
		assertEquals("LastName - +1", ExplosiveStringUtils.trimAndCollapseAllNonAsciiWith("LastName 中国人 +1", '-'));
		assertEquals(" - +1", ExplosiveStringUtils.trimAndCollapseAllNonAsciiWith(" 中国人 +1", '-'));
		//assertEquals(null, ExplosiveStringUtils.trimAndCollapseAllNonAsciiWith(null, '-'));
	}
	
	@Test
	public void test_Remove(){
		assertEquals("bdf rdbgd", ExplosiveStringUtils.remove("abcdf r,adbgdc,", "ac,"));
		assertEquals(null, ExplosiveStringUtils.remove(null, "ac,"));
	}
	
	@Test
	public void test_CommaDelimitedListToStringList(){
		ImmutableList<String> listStrings = ImmutableList.of("abc", "def", "hij");
		assertEquals(listStrings, ExplosiveStringUtils.commaDelimitedListToStringList("abc,def,hij"));
	}
	
	@Test
	public void test_IterableToCommaDelimitedString(){
		
		//List<String> listStrings = Arrays.asList("ab","cde","fg");
		ImmutableList<String > listStrings = ImmutableList.of("ab", "cde", "fg");
		
		assertEquals("ab,cde,fg", ExplosiveStringUtils.iterableToCommaDelimitedString(listStrings));
	}
	
	@Test
	public void TestMapToString(){
		/*
		Map<String,String> map = new HashMap<String, String>();
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		*/
		ImmutableMap<String,String> map = ImmutableMap.of("a", "1", "b", "2");
		assertEquals("a:1,b:2", ExplosiveStringUtils.mapToString(map));
	}
}
