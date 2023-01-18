package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	
	@Test
	void testArraySet_size()		// done 
	{
		// INTEGER TEST 
		ArraySet<Integer> two = new ArraySet<Integer>();
		assertEquals(0, two.size());
		
		two.add(9);
		assertEquals(1, two.size());
		
		two.add(5);
		two.add(5);
		two.add(5);
		assertEquals(2, two.size());
		
		two.add(5);
		two.add(100);
		two.add(84);
		assertEquals(4, two.size());
		
		two.clear();
		assertEquals(0, two.size());
		
		two.add(999);
		two.add(2345678);
		assertEquals(2, two.size());
		
		
		Integer testInt = 2; 
		two.remove(testInt);
		assertEquals(2, two.size());
		testInt = 999;
		two.remove(testInt);
		assertEquals(1, two.size());
		testInt = 2345678;
		two.remove(testInt);
		assertEquals(0, two.size());
		
		two.add(56);
		two.add(101);
		two.add(1);
		assertEquals(3, two.size());
		
		
		// DOUBLE TEST
		ArraySet<Double> three = new ArraySet<Double>();
		assertEquals(0, three.size());
		
		three.add(9.0);
		assertEquals(1, three.size());
		
		three.add(5.0);
		three.add(5.0);
		three.add(5.0);
		assertEquals(2, three.size());
		
		three.add(5.0);
		three.add(100.3);
		three.add(84.9);
		assertEquals(4, three.size());
				
		three.clear();
		assertEquals(0, three.size());
		
		three.add(999.888);
		three.add(2345678.1);
		assertEquals(2, three.size());
		
		three.remove(2.0);
		assertEquals(2, three.size());
		three.remove(999.888);
		assertEquals(1, three.size());
		three.remove(2345678.1);
		assertEquals(0, three.size());
				
		three.add(0.1);
		three.add(101.010101010);
		three.add(32.2);
		assertEquals(3, three.size());
		
		
	}
	
	

	@Test
	void testArraySet_add_element()
	{
		//Integer type
		ArraySet<Integer> test = new ArraySet<Integer>();
		assertFalse(test.contains(1));
				
		
		for (int i = 0; i < 20; i++)
		{
			test.add(i);
		}
		
		// add and make sure it added
		assertTrue(test.contains(2));
		assertTrue(test.contains(4));
		assertTrue(test.contains(17));
		
		// values not added, not in range
		assertFalse(test.contains(-4));
		assertFalse(test.contains(59));
		
		// zero and null
		assertTrue(test.contains(0));
		assertFalse(test.contains(null));
		
		// remove and check
		test.remove(6);
		assertFalse(test.contains(6));
		

		
		// double type
		ArraySet<Double> test2 = new ArraySet<Double>();
		assertFalse(test2.contains(1.1));
		
		// populate with values 0.1, 1.1, 2.2, ... 10.1
		for (double d = 0.1; d < 10.2; d++)
		{
			test2.add(d);
		}
		
		// add and make sure it added
		assertTrue(test2.contains(2.1));
		assertTrue(test2.contains(4.1));
		assertTrue(test2.contains(10.1));
		
		
		// values not added, not in range
		assertFalse(test2.contains(6));
		assertFalse(test2.contains(4.4));
		assertFalse(test2.contains(60.5));
		assertFalse(test2.contains(-8.1));
		
		// zero and null
		assertFalse(test2.contains(0));
		assertTrue(test2.contains(0.1));
		assertFalse(test.contains(null));
		
		// remove and check
		test2.remove(4.1);
		assertFalse(test2.contains(4.1));
		
	}
	
	@Test
	void testArraySet_add_elementAtIndex() {
		// integer type
		ArraySet<Integer> test = new ArraySet<Integer>();
		assertFalse(test.contains(1));
				
		// populate array
		for (int i = 0; i < 20; i++)
		{
			test.add(i, i);
		}
		
		// add and make sure it added
		assertTrue(test.contains(2));
		assertEquals(2, test.indexOf(2));
		assertTrue(test.contains(4));
		assertEquals(4, test.indexOf(4));
		assertTrue(test.contains(17));
		assertEquals(17, test.indexOf(17));
		
		// values not added, not in range
		assertFalse(test.contains(-4));
		assertFalse(test.contains(59));
		
		// zero and null
		assertTrue(test.contains(0));
		assertEquals(0, test.indexOf(0));
		assertFalse(test.contains(null));
		
		// remove and check
		test.remove(6);
		assertFalse(test.contains(6));
		
		
		// double type
		ArraySet<Double> test2 = new ArraySet<Double>();
		assertFalse(test2.contains(1.1));
				
		// populate with values 0.1, 1.1, 2.2, ... 10.1
		for (double d = 0.1; d < 10.2; d++)
		{
			test2.add(d);
		}
				
		// add and make sure it added
		assertTrue(test2.contains(2.1));
		assertEquals(2, test2.indexOf(2.1));
		assertTrue(test2.contains(4.1));
		assertEquals(4, test2.indexOf(4.1));
		assertTrue(test2.contains(10.1));
		assertEquals(10, test2.indexOf(10.1));
				
				
		// values not added, not in range
		assertFalse(test2.contains(6));
		assertFalse(test2.contains(4.4));
		assertFalse(test2.contains(60.5));
		assertFalse(test2.contains(-8.1));
				
		// zero and null
		assertFalse(test2.contains(0));
		assertTrue(test2.contains(0.1));
		assertEquals(0, test2.indexOf(0.1));
		assertFalse(test.contains(null));
				
		// remove and check
		test2.remove(4.1);
		assertFalse(test2.contains(4.1));
	}

	
	@Test
	void testArraySet_addAll() {
		// integer type
		ArraySet<Integer> test = new ArraySet<Integer>();
		ArraySet<Integer> insert = new ArraySet<Integer>();
		assertFalse(test.contains(1));
		assertTrue(test.isEmpty());
		
		// populate test array with values 0, 1, 2, 3, 4, 5
		for (int i = 0; i < 6; i++)
		{
			test.add(i);
		}
		
		// populate sub array with values not in set: 8, 9, 10, 11
		for (int j = 8; j < 12; j++)
		{
			insert.add(j);
		}
		
		assertTrue(test.addAll(insert));
		insert.clear();
		
		// populate sub array with some values in the set and some not: 10, 11, 12, 13
		for (int k = 10; k < 14; k++)
		{
			insert.add(k);
		}
		assertTrue(test.addAll(insert));
		insert.clear();
		
		// populate sub array with values in the set: 2, 3, 4, 5
		for (int l = 2; l < 6; l++)
		{
			insert.add(l);
		}
		assertFalse(test.addAll(insert));
		insert.clear();
		
		// empty array
		assertFalse(test.addAll(insert));
		
		
		
		
		
		// double type
		ArraySet<Double> test2 = new ArraySet<Double>();
		ArraySet<Double> insert2 = new ArraySet<Double>();
		assertFalse(test2.contains(1.0));
		assertTrue(test2.isEmpty());
				
		// populate test array with values 0.1, 1.1, 2.1, 3.1, 4.1, 5.1
		for (double m = 0.1; m < 6.1; m++)
		{
			test2.add(m);
		}
				
		// populate sub array with values not in set: 8.5, 9.5, 10.5, 11.5
		for (double n = 8.5; n < 12.5; n++)
		{
			insert2.add(n);
		}
				
		assertTrue(test2.addAll(insert2));
		insert2.clear();
				
		// populate sub array with some values in the set and some not: 10.5, 11.5, 12.5, 13.5
		for (double o = 10.5; o < 14.5; o++)
		{
			insert2.add(o);
		}
		assertTrue(test2.addAll(insert2));
		insert2.clear();
				
		// populate sub array with values in the set: 2.1, 3.1, 4.1, 5.1
		for (double p = 2.1; p < 6.1; p++)
		{
			insert2.add(p);
		}
		assertFalse(test2.addAll(insert2));
		insert2.clear();
				
		// empty array
		assertFalse(test2.addAll(insert2));
		
		
	}
	
	@Test
	void testArraySet_addAll_atIndex() {
		
		
		
	}
	
}
























