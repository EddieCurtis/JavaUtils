package com.github.eddiecurtis.javautils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Test class for {@link HashableKey}
 * @author Eddie Curtis
 * @date 19 Nov 2014
 */
public class HashableKeyTest {

	private static final String STRING_VALUE = "A";

	@Test
	public void testHashableKeyEquals() throws Exception {
		HashableKey<?> one = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		HashableKey<?> two = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		assertEquals(one, two);
	}
	
	@Test
	public void testHashableKeyEqualsSameReference() throws Exception {
		HashableKey<?> key = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		assertTrue(key.equals(key));
	}
	
	@Test
	public void testHashableKeyEqualsNullValues() throws Exception {
		HashableKey<?> one = new HashableKey<Object>((Object)null);
		HashableKey<?> two = new HashableKey<String>((String)null);
		assertEquals(one, two);
	}
	
	@Test
	public void testHashableKeyEqualsEmpty() throws Exception {
		HashableKey<?> one = new HashableKey<Object>();
		HashableKey<?> two = new HashableKey<Object>();
		assertEquals(one, two);
	}
	
	@Test
	public void testHashableKeyEqualsNullKey() throws Exception {
		HashableKey<?> key = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		assertFalse(key.equals(null));
	}
	
	@Test
	public void testHashableKeyEqualsOtherObject() throws Exception {
		HashableKey<?> key = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		assertFalse(key.equals(STRING_VALUE));
	}
	
	@Test
	public void testHashableKeyEqualsNullValue() throws Exception {
		HashableKey<?> one = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		HashableKey<?> two = new HashableKey<Object>(STRING_VALUE, null);
		assertFalse(one.equals(two));
	}
	
	@Test
	public void testHashableKeyEqualsDifferentSize() throws Exception {
		HashableKey<?> one = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		HashableKey<?> two = new HashableKey<Object>(STRING_VALUE);
		assertFalse(one.equals(two));
	}
	
	@Test
	public void testHashableKeyEqualsNotEqual() throws Exception {
		HashableKey<?> one = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		HashableKey<?> two = new HashableKey<Object>(STRING_VALUE, Boolean.FALSE);
		assertFalse(one.equals(two));
	}
	
	@Test
	public void testHashableKeyHashcodes() throws Exception {
		HashableKey<?> one = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		HashableKey<?> two = new HashableKey<Object>(STRING_VALUE, Boolean.TRUE);
		assertEquals(one.hashCode(), two.hashCode());
	}
	
	@Test
	public void testHashableKeyHashcodesEmpty() throws Exception {
		HashableKey<?> one = new HashableKey<Object>();
		HashableKey<?> two = new HashableKey<Object>();
		assertEquals(one.hashCode(), two.hashCode());
	}
	
	@Test
	public void testHashableKeyHashcodesNull() throws Exception {
		HashableKey<?> one = new HashableKey<String>((String)null);
		HashableKey<?> two = new HashableKey<Object>((Object)null);
		assertEquals(one.hashCode(), two.hashCode());
	}
	
	@Test
	public void testHashableKeyHashcodesDifferent() throws Exception {
		HashableKey<?> one = new HashableKey<String>(STRING_VALUE);
		HashableKey<?> two = new HashableKey<Object>((Object)null);
		assertFalse(one.hashCode() == two.hashCode());
	}

}
