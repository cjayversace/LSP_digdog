/*
 * This class is a JUnit test class for the IntegerRange class
 * It tests the methods of IntegerRange such as get_lower, get_upper, contains, overlaps, and size
 */

package org.howard.edu.lsp.midterm.problem51;

import static org.junit.jupiter.api.Assertions.*;

import org.howard.edu.lsp.midterm.problem51.Range.EmptyRangeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class IntegerRangeTest {

	// create an instance of IntegerRange for testing
	IntegerRange my_range;
	
	@BeforeEach
	void setUp() throws Exception {
		// initialize the instance with a lower bound of 0 and an upper bound of 100
		my_range = new IntegerRange(0, 100);
	}

	@AfterEach
	void tearDown() throws Exception {
		my_range = null;
	}

	@Test
	@DisplayName("Test for get_lower")
	void testGetLower() {
		// test that the get_lower method returns the correct value
		assertEquals(my_range.get_lower(), 0);
	}
	
	@Test
	@DisplayName("Test for get_upper")
	void testGetUpper() {
		// test that the get_upper method returns the correct value
		assertEquals(my_range.get_upper(), 100);
	}
	
	@Test
	@DisplayName("Test for contains")
	void testContains() {
		// test that the contains method correctly identifies whether a value is within the range
		assertTrue(my_range.contains(56));
		assertFalse(my_range.contains(789));
		assertFalse(my_range.contains(-34));
		assertTrue(my_range.contains(100));
	}
	
	@Test
	@DisplayName("Test for overlaps")
	void testOverlaps() throws EmptyRangeException {
		// test that the overlaps method correctly identifies whether two ranges overlap
		IntegerRange your_range;
		
		your_range = new IntegerRange(50, 75);
		assertTrue(my_range.overlaps(your_range));
		assertTrue(your_range.overlaps(my_range));
		
		your_range = new IntegerRange(89, 143);
		assertTrue(my_range.overlaps(your_range));
		assertTrue(your_range.overlaps(my_range));
		
		your_range = new IntegerRange(-10, 5);
		assertTrue(my_range.overlaps(your_range));
		assertTrue(your_range.overlaps(my_range));
		
		your_range = new IntegerRange(101, 456);
		assertFalse(my_range.overlaps(your_range));
		assertFalse(your_range.overlaps(my_range));
	}
	
	@Test
	@DisplayName("Test for EmptyRangeException")
	void testOverlapsException() {
		// test that the overlaps method throws an EmptyRangeException when the other range is null
		IntegerRange your_range = null;
		
		assertThrows(EmptyRangeException.class, () -> my_range.overlaps(your_range));
	}
	
	@Test
	@DisplayName("Test for size")
	void testSize() {
		// test that the size method correctly calculates the size of the range
		IntegerRange your_range;
		
		your_range = new IntegerRange(25, 50);
		assertEquals(your_range.size(), 25);
		
		your_range = new IntegerRange(78, 143);
		assertEquals(your_range.size(), 65);
		
		your_range = new IntegerRange(-10, 10);
		assertEquals(your_range.size(), 20);
		
		assertEquals(my_range.size(), 100);
	}
}
