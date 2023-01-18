package utilities;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Dictionary;

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
		// putAll with an empty dictionary and empty hashtable 
		ParallelArrayDictionary<Integer, Double> one = new ParallelArrayDictionary<Integer, Double>();
		Hashtable<Integer, Double> m = new Hashtable<Integer, Double>();
		
		one.putAll(m);
		assertEquals(0, one.size());
		
		// putAll with an empty dictionary and non-empty hashtable
		double dub = 12.03;
		for (int i=0; i<10; i++) {
			m.put(i, dub+i);
		}
		one.putAll(m);
		assertEquals(10, one.size());
		
		// putAll with an empty dictionary and non-empty hashtable
		m.clear();
		dub = 5.5;
		for (int i=0; i<10; i++) {
			m.put(i, dub+i);
		}
		one.putAll(m);
		assertEquals(10, one.size());
		
		m.clear();
		dub = 8.01234;
		for (int i=10; i<20; i++) {
			m.put(i, dub+i);
		}
		one.putAll(m);
		assertEquals(20, one.size());
		
		// putAll after clearing the dictionary 
		one.clear();
		one.putAll(m);
		assertEquals(10, one.size());
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
		// empty dictionary - returns an empty list
		ParallelArrayDictionary<Integer, Double> one = new ParallelArrayDictionary<Integer, Double>();
		assertEquals(Arrays.asList(), one.keySet());
		
		// add keys - returns correct key set
		double dub = 100.0;
		for (int i=0; i<15; i++) {
			assertEquals(dub, one.put(i, dub));
		}
		assertEquals(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14), one.keySet());
		
		// non-empty dictionary - return a non-empty list
		ParallelArrayDictionary<Integer, Double> two = 
				new ParallelArrayDictionary<Integer, Double>
				(new ArraySet<Integer>(new ArrayList<Integer>
				(Arrays.asList(1, 2, 3))), new ArrayList<Double>
				(Arrays.asList(1.1, 2.2, 3.3)));
		assertEquals(Arrays.asList(1,2,3), two.keySet());
		
		// clear dictionary - returns an empty list
		two.clear();
		assertEquals(Arrays.asList(), two.keySet());
	}
	
	@Test
	void ParallelArrayDictionary_values()
	{
		// INTEGER TEST
		// empty dictionary - returns an empty list
		ParallelArrayDictionary<Integer, Integer> one = new ParallelArrayDictionary<Integer, Integer>();
		assertEquals(Arrays.asList(), one.values());

		// add values - returns correct value set
		for (int i=0; i<15; i++) {
			assertEquals(i+1, one.put(i, i+1));
		}
		assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15), one.values());

		// non-empty dictionary - return a non-empty list
		ParallelArrayDictionary<Integer, Integer> two = 
				new ParallelArrayDictionary<Integer, Integer>
		(new ArraySet<Integer>(new ArrayList<Integer>
		(Arrays.asList(1, 2, 3))), new ArrayList<Integer>
		(Arrays.asList(4, 5, 6)));
		assertEquals(Arrays.asList(4, 5, 6), two.values());

		// clear dictionary - returns an empty list
		two.clear();
		assertEquals(Arrays.asList(), two.values());

		
		// DOUBLE TEST
		// empty dictionary - returns an empty list
		ParallelArrayDictionary<Integer, Double> three = new ParallelArrayDictionary<Integer, Double>();
		assertEquals(Arrays.asList(), three.values());
		
		// add values - returns correct value set
		double dub = 100.2;
		for (int i=0; i<15; i++) {
			assertEquals(dub, three.put(i, dub));
		}
		assertEquals(Arrays.asList(100.2,100.2,100.2,100.2,100.2,100.2,100.2,100.2,100.2,100.2,100.2,100.2,100.2,100.2,100.2), three.values());
		
		// non-empty dictionary - return a non-empty list
		ParallelArrayDictionary<Integer, Double> four = 
				new ParallelArrayDictionary<Integer, Double>
		(new ArraySet<Integer>(new ArrayList<Integer>
		(Arrays.asList(1, 2, 3))), new ArrayList<Double>
		(Arrays.asList(1.1, 2.2, 3.3)));
		assertEquals(Arrays.asList(1.1,2.2,3.3), four.values());

		// clear dictionary - returns an empty list
		four.clear();
		assertEquals(Arrays.asList(), four.values());
	}
	

}
