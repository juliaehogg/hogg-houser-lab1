package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	
	@Test
	void testArraySet_construction()
	{
		ArraySet<Double> one = new ArraySet<Double>();
		
		assertEquals(0, one.size());
		
		
	}
	
	@Test
	void testArraySet_size()
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
		assertEquals(7, two.size());
		
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
		/*
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
		
		
		*/
	}
	
	
	
	
	
	
	@Test
	void testArraySet_isEmpty()
	{
		// INTEGER TEST
		ArraySet<Integer> one = new ArraySet<Integer>();
		assertTrue(one.isEmpty());
		
		one.add(9);
		assertFalse(one.isEmpty());
		
		for (int i=0; i<10; i++) {
			one.add(i);
			assertFalse(one.isEmpty());
		}
		
		one.clear();
		assertTrue(one.isEmpty());
		
		for (int i=0; i<10; i++) {
			one.add(i*4);
			assertFalse(one.isEmpty());
		}
		
		one.clear();
		assertTrue(one.isEmpty());
		
		one.add(7);
		one.add(9);
		assertFalse(one.isEmpty());
		
		one.remove(new Integer(2));		// ask alvin if this is right
		assertFalse(one.isEmpty());
		one.remove(new Integer(7));		// ask alvin if this is right 
		assertFalse(one.isEmpty());
		one.remove(new Integer(9));		// ask alvin if this is right 
		assertTrue(one.isEmpty());
		
		
		
		// DOUBLE TEST
		ArraySet<Double> two = new ArraySet<Double>();
		assertTrue(two.isEmpty());
		
		two.add(9.002);
		assertFalse(two.isEmpty());
		
		for (double i=0; i<10; i++) {
			two.add(i);
			assertFalse(two.isEmpty());
		}
		
		two.clear();
		assertTrue(two.isEmpty());
		
		for (double i=0; i<10; i++) {
			two.add(i*4);
			assertFalse(two.isEmpty());
		}
		
		two.clear();
		assertTrue(two.isEmpty());
		
		two.add(7.19);
		two.add(9.12345678);
		assertFalse(two.isEmpty());
		
		two.remove(new Double(2));				// ask alvin if this is right
		assertFalse(two.isEmpty());
		two.remove(new Double(7.19));			// ask alvin if this is right 
		assertFalse(two.isEmpty());
		two.remove(new Double(9.12345678));		// ask alvin if this is right 
		assertTrue(two.isEmpty());
		
		
		// STRING TEST
		ArraySet<String> three = new ArraySet<String>();
		assertTrue(three.isEmpty());
		
		three.add("Here");
		assertFalse(three.isEmpty());
		
		for (int i=0; i<10; i++) {
			three.add("Hello number " + i);
			assertFalse(three.isEmpty());
		}
		
		three.clear();
		assertTrue(three.isEmpty());
		
		for (int i=0; i<10; i++) {
			three.add("i love numbers: " + (i*2));
			assertFalse(three.isEmpty());
		}
		
		three.clear();
		assertTrue(three.isEmpty());
		
		three.add("79");
		three.add("this is a String");
		assertFalse(three.isEmpty());
		
		three.remove("Julia");					// ask alvin if this is right
		assertFalse(three.isEmpty());
		three.remove("79");						// ask alvin if this is right 
		assertFalse(three.isEmpty());
		three.remove("this is a String");		// ask alvin if this is right 
		assertTrue(three.isEmpty());

		
	}
	
	
	
	@Test
	void testArraySet_contains()
	{
		//Integer type
		ArraySet<Integer> test = new ArraySet<Integer>();
		assertFalse(test.contains(1));
		
		for (int i = 0; i <15; i++)
		{
			test.add(i);
		}
		
		// add & make sure it's there
		assertTrue(test.contains(4));
		assertTrue(test.contains(9));
		assertTrue(test.contains(2));
		
		//outside of range
		assertFalse(test.contains(17));
		assertFalse(test.contains(-4));
		
		//zero and null
		assertTrue(test.contains(0));
		assertFalse(test.contains(null));
		
		//remove & make sure it removes
		test.remove(4);
		assertFalse(test.contains(4));
		
		// clear and make sure it contains nothing
		test.clear();
		assertFalse(test.contains(5));
		
		
		// Double type
		ArraySet<Double> test2 = new ArraySet<Double>();
		assertFalse(test.contains(1.0));
		
		for (double d = 0.0; d < 15; d++)
		{
			test2.add(d);
		}
		
		// add and make sure it's there
		assertTrue(test2.contains(4.0));
		assertTrue(test2.contains(9.0));
		assertTrue(test2.contains(11.0));
		
		// add specific double and check
		test2.add(19.2);
		assertTrue(test2.contains(19.2));
		
		//outside of range
		assertFalse(test2.contains(4002.4));
		assertFalse(test2.contains(-9.2));
		
		//zero and null
		assertTrue(test2.contains(0.0));
		assertFalse(test2.contains(null));
		
		// remove and make sure it removes
		test2.remove(5.0);
		assertFalse(test2.contains(5.0));
		
		// clear and make sure it contains nothing
		test2.clear();
		assertFalse(test2.contains(3.2));
		
		
		
		//String type
		ArraySet<String> test3 = new ArraySet<String>();
		assertFalse(test3.contains("hello"));
		
		test3.add("giraffe");
		test3.add("monkey");
		test3.add("chimp");
		test3.add("fish");
		
		
		// and and check same word w one letter altered
		test3.add("elephant");
		assertTrue(test3.contains("elephant"));
		assertFalse(test3.contains("elephants"));
		
		// check what was added
		assertTrue(test3.contains("monkey"));
		assertFalse(test3.contains("himp"));
		
		// remove and make sure it doesn't contain it
		test3.remove("elephant");
		assertFalse(test3.contains("elephant"));
		
		// check words not there
		assertFalse(test3.contains("yellow"));
		String b = "";
		assertFalse(test3.contains(b));
		
		//clear and make sure it contains nothing
		test3.clear();
		assertFalse(test3.contains("monkey"));
		assertFalse(test3.contains("hello"));
		

	}
	
	@Test
	void testArraySet_iterator()
	{
	}
	
	@Test
	void testArraySet_toArray()
	{
	}
	
	@Test
	void testArraySet_add()
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
	void testArraySet_remove()
	{
	}
	
	@Test
	void testArraySet_containsAll()
	{
	}
	
	@Test
	void testArraySet_addAll()
	{
	}
	
	@Test
	void testArraySet_removeAll()
	{
	}
	
	@Test
	void testArraySet_retainAll()
	{
	}
	
	@Test
	void testArraySet_clear()
	{
		//INTEGER TESTING 
		ArraySet<Integer> testCI = new ArraySet<Integer>();
		assertEquals(testCI.size(), 0);
		
		for (int i = 0; i < 10; i++)
		{
			testCI.add(i);
		}
		
		// add a bunch and make sure it isn't empty
		assertFalse(testCI.isEmpty());
		
		
		// clear and make sure it's empty
		testCI.clear();	
		assertTrue(testCI.isEmpty());
		assertEquals(testCI.size(), 0);
		
		// add one and make sure it isn't empty
		testCI.add(1);
		assertFalse(testCI.isEmpty());
		
		
		// double test
		ArraySet<Double> testCD = new ArraySet<Double>();
		assertTrue(testCD.isEmpty());
		assertEquals(testCD.size(), 0);
		
		for (double d = 0.0; d < 15; d++)
		{
			testCD.add(d);
		}
		
		// add a bunch and make sure it isn't empty
		assertFalse(testCD.isEmpty());
		
		// clear and make sure it's empty
		testCD.clear();
		assertTrue(testCD.isEmpty());
		assertEquals(testCD.size(), 0);
		
		// add one and make sure it isn't empty
		testCD.add(1.1);
		assertFalse(testCD.isEmpty());
		
		
		// string test
		ArraySet<String> testCS = new ArraySet<String>();
		assertTrue(testCS.isEmpty());
		assertEquals(testCS.size(), 0);
		
		
		// add and make sure it isnt empty
		testCS.add("Hello");
		testCS.add("Goodbye");
		assertFalse(testCS.isEmpty());
		
		// clear and make sure its empty
		testCS.clear();
		assertTrue(testCS.isEmpty());
		assertEquals(testCS.size(), 0);
		
		// add one and make sure it isn't empty
		testCS.add("Julia");
		assertFalse(testCS.isEmpty());
		
	}
	
	@Test
	void testArraySet_get()
	{
	}
	
	@Test
	void testArraySet_set()
	{
	}
	
	@Test
	void testArraySet_lastIndexOf()
	{
	}
	
	@Test
	void testArraySet_listIterator()
	{
	}
	
	@Test
	void testArraySet_subList()
	{
	}
	
	@Test
	void testArraySet_spliterator()
	{
	}
	
	
	
	
	
	
	
	
	
	// generated tests 
	
	
	@Test
	void testArraySetCollectionOfE()
	{
	}

	@Test
	void testAddE()
	{
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
	}

	@Test
	void testRetainAll()
	{
	}

	@Test
	void testRemoveAll()
	{
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
	}
	
}
