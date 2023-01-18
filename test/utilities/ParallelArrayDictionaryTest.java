package utilities;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	
	
	@Test
	void ParallelArrayDictionary_get()
	{
		// getting values in and outside of the dictionary
		ParallelArrayDictionary<Integer, Double> one = 
				new ParallelArrayDictionary<Integer, Double>
				(new ArraySet<Integer>(new ArrayList<Integer>
				(Arrays.asList(1, 2, 3))), new ArrayList<Double>
				(Arrays.asList(1.1, 2.2, 3.3)));
		
		assertNull(one.get(5));
		assertNull(one.get(0));
		assertEquals(1.1, one.get(1));
		assertEquals(2.2, one.get(2));
		assertEquals(3.3, one.get(3));
		
		// getting values in and outside of the dictionary
		ParallelArrayDictionary<Integer, Double> two = 
				new ParallelArrayDictionary<Integer, Double>
				(new ArraySet<Integer>(new ArrayList<Integer>
				(Arrays.asList(3, 4, 2))), new ArrayList<Double>
				(Arrays.asList(3.3, 4.4, 2.2)));
		
		assertNull(two.get(1));
		assertEquals(2.2, two.get(2));
		assertEquals(3.3, two.get(3));
		assertEquals(4.4, two.get(4));
		assertNull(two.get(5));
		
		// removing and getting non-existent value
		two.remove(4);
		assertNull(two.get(4));
		
		// putting and getting new existent value
		two.put(4, 9.9);
		assertEquals(9.9, two.get(4));
	}
	
	
	
	
	@Test
	void ParallelArrayDictionary_put()
	{
		// putting values inside an empty dictionary 
		ParallelArrayDictionary<Integer, Double> one = new ParallelArrayDictionary<Integer, Double>();
		assertEquals(55.1234, one.put(9, 55.1234));
		
		// putting values inside an empty dictionary from remove function 
		one.remove(9);
		assertEquals(10001.1, one.put(9, 10001.1));
		assertEquals(108.2, one.put(41, 108.2));
		
		// putting values inside a dictionary with established keys/values 
		ParallelArrayDictionary<Integer, Double> two = 
				new ParallelArrayDictionary<Integer, Double>
				(new ArraySet<Integer>(new ArrayList<Integer>
				(Arrays.asList(1, 2, 3))), new ArrayList<Double>
				(Arrays.asList(1.1, 2.2, 3.3)));
		
		double dub = 12.0;
		for (int i=0; i<11; i++) {
			assertEquals(dub, two.put(i, dub));
		}
	}
	
	
	
	@Test
	void ParallelArrayDictionary_remove()
	{
		// remove from an empty dictionary
		ParallelArrayDictionary<Integer, Double> one = new ParallelArrayDictionary<Integer, Double>();
		assertNull(one.remove(2));
		assertNull(one.remove(5));
		assertNull(one.remove(null));
		assertNull(one.remove(0));
		
		// remove from a dictionary after adding keys/values 
		one.put(1, 2.3);
		one.put(4, 5.6);
		assertEquals(2.3, one.remove(1));
		assertEquals(5.6, one.remove(4));
		
		// remove from an empty dictionary
		assertNull(one.remove(1));
		assertNull(one.remove(4));
		assertNull(one.remove(null));
		assertNull(one.remove(2));
		
		// remove from a dictionary after adding keys/values 
		one.put(8, 100000.1);
		one.put(9, 2.000001);
		assertEquals(100000.1, one.remove(8));
		assertEquals(2.000001, one.remove(9));	
		
		// remove from a dictionary with established keys/values 
		ParallelArrayDictionary<Integer, Double> two = 
				new ParallelArrayDictionary<Integer, Double>
				(new ArraySet<Integer>(new ArrayList<Integer>
				(Arrays.asList(1, 2, 3))), new ArrayList<Double>
				(Arrays.asList(1.1, 2.2, 3.3)));
		assertEquals(1.1, two.remove(1));
		assertEquals(2.2, two.remove(2));
		assertEquals(3.3, two.remove(3));
		
		// remove from a dictionary after adding keys/values 
		two.put(2, 12345.6);
		two.put(3, 89089089.0);
		assertEquals(12345.6, two.remove(2));
		assertEquals(89089089.0, two.remove(3));
	}
	
	@Test
	void ParallelArrayDictionary_putAll()
	{
		// here 
	}
	
	
	@Test
	void ParallelArrayDictionary_clear()
	{
		// clearing an empty dictionary 
		ParallelArrayDictionary<Integer, Double> one = new ParallelArrayDictionary<Integer, Double>();
		one.clear();
		assertEquals(0, one.size());
		one.clear();
		assertEquals(0, one.size());
		
		// clearing after putting values in empty dictionary
		double dub = 12.0;
		for (int i=0; i<11; i++) {
			assertEquals(dub, one.put(i, dub));
		}
		one.clear();
		assertEquals(0, one.size());
		
		// clearing an empty dictionary 
		one.clear();
		assertEquals(0, one.size());
		
		
		// clearing from a dictionary with established keys/values
		ParallelArrayDictionary<Integer, Double> two = 
				new ParallelArrayDictionary<Integer, Double>
				(new ArraySet<Integer>(new ArrayList<Integer>
				(Arrays.asList(1, 2, 3))), new ArrayList<Double>
				(Arrays.asList(1.1, 2.2, 3.3)));
		two.clear();
		assertEquals(0, two.size());
		
		// clearing an empty dictionary 
		two.clear();
		assertEquals(0, two.size());
		
		// clearing after putting values in empty dictionary
		dub = 100.0;
		for (int i=0; i<15; i++) {
			assertEquals(dub, two.put(i, dub));
		}
		two.clear();
		assertEquals(0, two.size());
	}
	
	
	@Test
	void ParallelArrayDictionary_keySet()
	{
		// here 
	}
	
	@Test
	void ParallelArrayDictionary_values()
	{
		// here 
	}
	

}

















