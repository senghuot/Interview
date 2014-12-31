package ixl.test;

import static org.junit.Assert.*;
import ixl.Question2;

import org.junit.Test;

public class Question2Test {

	@Test(expected = IllegalArgumentException.class)
	public void testEdgeCases() {
		// input is null, exception is being catch on the method header
		Question2.allStringSetsIdentical(null);
		
		// set is empty
		assertTrue(Question2.allStringSetsIdentical(new String[][]{{}}));
	}

	@Test
	public void testHappyCases() {		
		// empty set
		String[][] input2 = new String[][] {};
		assertTrue(Question2.allStringSetsIdentical(input2));
		
		// set contains one set
		String[][] input3 = new String[][] {{"a", "b", "c"}};
		assertTrue(Question2.allStringSetsIdentical(input3));
		
		// set contains many sets
		String[][] input = new String[][] {{"a","b"},{"b","b","a"},{"b","a"}};
		assertTrue(Question2.allStringSetsIdentical(input));
		
		String[][] input4 = new String[][] {{"x","y", "z"},{"x","y", "z", "z", "x"},{"z", "y", "x"},{"x", "x", "y", "z"}};
		assertTrue(Question2.allStringSetsIdentical(input4));
	}
	
	@Test
	public void testBadCases() {
		String[][] input = new String[][] {{"a","b"},{"a"},{"b"}};
		assertFalse(Question2.allStringSetsIdentical(input));
		
		String[][] input2 = new String[][] {{"a"},{"a"},{"b"}};
		assertFalse(Question2.allStringSetsIdentical(input2));
	}
}
