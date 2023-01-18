package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	
	@Test
	void testArraySet_size()
	{
		// INTEGER TEST 
		ArraySet<Integer> two = new ArraySet<Integer>();
		assertEquals(0, two.size());
		
		
		// add values and check size
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
		
		// clear and check size
		two.clear();
		assertEquals(0, two.size());
		
		
		// add values and check size
		two.add(999);
		two.add(2345678);
		assertEquals(2, two.size());
		
		// add and remove and check size
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
		
		// add values and check size
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
		
		// clear and check size
		three.clear();
		assertEquals(0, three.size());
		
		// add values and check size
		three.add(999.888);
		three.add(2345678.1);
		assertEquals(2, three.size());
		
		// add and remove and check size
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
		// INTEGER TEST
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
		

		
		// DOUBLE TEST
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
		// INTEGER TEST
		ArraySet<Integer> test = new ArraySet<Integer>();
		assertFalse(test.contains(1));
				
		// populate array with values 0-19
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
		
		
		// DOUBLE TEST
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
		// INTEGER TEST
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
		
		
		
		
		
		// DOUBLE TEST
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
		// integer test
		ArraySet<Integer> test = new ArraySet<Integer>();
		ArraySet<Integer> insert = new ArraySet<Integer>();
		assertFalse(test.contains(1));
		assertTrue(test.isEmpty());
		
		// populate test array with values 1-5
		for (int i = 0; i < 6; i++)
		{
			test.add(i);
		}
		
		// populate insert array with values 8-10 (outside of range) at end 
		for (int j = 8; j < 11; j++)
		{
			insert.add(j);
		}
		
		assertTrue(test.addAll(test.size() -1, insert));
		assertEquals(9, test.size());
		insert.clear();
		
		// populate insert array with values 6-7 at index 6 (middle)
		for (int k = 6; k < 8; k++)
		{
			insert.add(k);
		}
		
		assertTrue(test.addAll(6, insert));
		assertEquals(11, test.size());
		insert.clear();
		
		// populate insert array with values 0, 1 at beginning 
		for (int l = 0; l < 2; l++)
		{
			insert.add(l);
		}
		
		assertFalse(test.addAll(0, insert));
		assertEquals(11, test.size());
		insert.clear();
		
		// populate insert array with values 12, 13, 14 and add to beginning
		for (int m = 12; m < 15; m++)
		{
			insert.add(m);
		}
		
		assertTrue(test.addAll(0, insert));
		assertEquals(14, test.size());
		insert.clear();
		
		// populate insert array with values in the test array and values not in the test array
		for (int n = 15; n < 20; n++)
		{
			insert.add(n);
		}
		
		assertTrue(test.addAll(test.size()-1, insert));
		assertEquals(19, test.size());
		
		// empty array
		insert.clear();
		assertFalse(test.addAll(0, insert));
		
		
		
		// double test
				ArraySet<Double> test2 = new ArraySet<Double>();
				ArraySet<Double> insert2 = new ArraySet<Double>();
				assertFalse(test2.contains(1));
				assertTrue(test2.isEmpty());
				
				// populate test array with values 0.1 1.1, 2.1, 3.1, 4.1, 5.1 
				for (double i = 0.1; i < 6.1; i++)
				{
					test2.add(i);
				}
				
				// populate insert array with values 8.1, 9.1, 10.1 (outside of range) at end 
				for (double j = 8.1; j < 11.1; j++)
				{
					insert2.add(j);
				}
				
				assertTrue(test2.addAll(test2.size() -1, insert2));
				assertEquals(9, test2.size());
				insert2.clear();
				
				// populate insert array with values 6.1, 7.1 at index 6 (middle)
				for (double k = 6.1; k < 8; k++)
				{
					insert2.add(k);
				}
				
				assertTrue(test2.addAll(6, insert2));
				assertEquals(11, test2.size());
				insert2.clear();
				
				// populate insert array with values 0, 1 at beginning 
				for (double l = 0.1; l < 2; l++)
				{
					insert2.add(l);
				}
				
				assertFalse(test2.addAll(0, insert2));
				assertEquals(11, test2.size());
				insert2.clear();
				
				// populate insert array with values 12.1, 13.1, 14 and add to beginning
				for (double m = 12.1 ; m < 15; m++)
				{
					insert2.add(m);
				}
				
				assertTrue(test2.addAll(0, insert2));
				assertEquals(14, test2.size());
				insert2.clear();
				
				// populate insert array with values in the test array and values not in the test array
				for (double n = 15.1; n < 20; n++)
				{
					insert2.add(n);
				}
				
				assertTrue(test2.addAll(test2.size()-1, insert2));
				assertEquals(19, test2.size());
				
				// empty array
				insert2.clear();
				assertFalse(test2.addAll(0, insert2));
		
	}
	
	
}
























