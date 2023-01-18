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
		
		assertEquals(null, one.get(5));
		assertEquals(null, one.get(0));
		assertEquals(1.1, one.get(1));
		assertEquals(2.2, one.get(2));
		assertEquals(3.3, one.get(3));
		
		// getting values in and outside of the dictionary
		ParallelArrayDictionary<Integer, Double> two = 
				new ParallelArrayDictionary<Integer, Double>
				(new ArraySet<Integer>(new ArrayList<Integer>
				(Arrays.asList(3, 4, 2))), new ArrayList<Double>
				(Arrays.asList(3.3, 4.4, 2.2)));
		
		assertEquals(null, two.get(1));
		assertEquals(2.2, two.get(2));
		assertEquals(3.3, two.get(3));
		assertEquals(4.4, two.get(4));
		assertEquals(null, two.get(5));
		
		// removing and getting non-existent value
		two.remove(4);
		assertEquals(null, two.get(4));
		
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
		one.remove(9);
		assertEquals(10001.1, one.put(9, 10001.1));
		assertEquals(108.2, one.put(41, 108.2));
		
		
		// putting values inside a dictionary 
		ParallelArrayDictionary<Integer, Double> two = 
				new ParallelArrayDictionary<Integer, Double>
				(new ArraySet<Integer>(new ArrayList<Integer>
				(Arrays.asList(1, 2, 3))), new ArrayList<Double>
				(Arrays.asList(1.1, 2.2, 3.3)));
		
		double dub = 12.0;
		for (int i=0; i<11; i++) {
			assertEquals(dub, one.put(i, dub));
		}
	}
	
	
	
	@Test
	void ParallelArrayDictionary_remove()
	{
		// here 
	}
	
	@Test
	void ParallelArrayDictionary_putAll()
	{
		// here 
	}
	
	
	@Test
	void ParallelArrayDictionary_clear()
	{
		// here 
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

















