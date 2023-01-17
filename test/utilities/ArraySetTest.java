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
		// Integer type
		ArraySet<Integer> two = new ArraySet<Integer>();
		assertEquals(0, two.size());
		
		two.add(9);
		assertEquals(1, two.size());
		
		two.add(5);
		two.add(5);
		two.add(5);
		assertEquals(4, two.size());
		
		two.add(5);
		two.add(100);
		two.add(84);
		assertEquals(7, two.size());
		
		two.clear();
		assertEquals(0, two.size());
		
		two.add(999);
		two.add(2345678);
		assertEquals(2, two.size());
		
		two.remove(2);
		assertEquals(2, two.size());
		two.remove(999);
		assertEquals(1, two.size());
		two.remove(2345678);
		assertEquals(0, two.size());
		
		two.add(56);
		two.add(101);
		two.add(1);
		assertEquals(3, two.size());
		
		
		// Double type
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
		
		
		// String type
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
	void testArraySet_isEmpty()
	{
		// Integer type
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
		
		
		
		// Double type
		ArraySet<Integer> two = new ArraySet<Integer>();
		//assertFalse(two.isEmpty());


		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	void testArraySet_contains()
	{
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
