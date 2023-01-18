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
		
		
		// STRING TEST
		ArraySet<String> four = new ArraySet<String>();
		assertEquals(0, four.size());

		four.add("hello ");
		assertEquals(1, four.size());

		four.add("here");
		four.add("here");
		four.add("here");
		assertEquals(2, four.size());

		four.add("here");
		four.add("is a ");
		four.add("butterfly");
		assertEquals(4, four.size());

		four.clear();
		assertEquals(0, four.size());

		four.add("");
		four.add("okay! cool <3");
		assertEquals(2, four.size());
		
		four.remove("not");
		assertEquals(2, four.size());
		four.remove("");
		assertEquals(1, four.size());
		four.remove("okay! cool <3");
		assertEquals(0, four.size());
		
		four.add("tricky");
		four.add("it is the start of the Furman semester");
		four.add("!@#$%^&*()_+{}[]:\' oh how fancy");
		assertEquals(3, four.size());
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
		
		
	}
	
	
	
	
	
	@Test
	void testArraySet_add_elementAtIndex() {
		
		
		
	}

	
	@Test
	void testArraySet_addAll() {
		
		
		
	}
	
	@Test
	void testArraySet_addAll_atIndex() {
		
		
		
	}
	
}
























