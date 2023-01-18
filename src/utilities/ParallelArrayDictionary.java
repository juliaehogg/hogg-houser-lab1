package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ParallelArrayDictionary <Key, Value> implements Map<Key, Value>
{
	// Parallel array-based implementation
	 protected ArraySet<Key> _keys;
	 protected ArrayList<Value> _values;

	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArrayList<Value>();
	}
	
	public ParallelArrayDictionary(ArraySet<Key> keys2, ArrayList<Value> values2)
	{
		_keys = keys2;
		_values = values2;
	}

	@Override
	public int size() {
		return _keys.size();
	}

	@Override
	public boolean isEmpty() {
		return _keys.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return _keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return _values.contains(value);

	}

	@Override
	public Value get(Object key) {
		if (!_keys.contains(key)) return null;
		return _values.get(_keys.indexOf(key));
	}

	@Override
	public Value put(Key key, Value value) {
		_keys.add(key);
		_values.add(value);
		return value;
	}

	@Override
	public Value remove(Object key) {
		int index = _keys.indexOf(key);
		_keys.remove(index);
		Value val = _values.get(index);
		_values.remove(index);
		return val;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		for (Entry<? extends Key, ? extends Value> e: m.entrySet()) { 
			put(e.getKey(), e.getValue());
		}
	}

	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}

	@Override
	public Set<Key> keySet() {
		return _keys;
	}

	@Override
	public Collection<Value> values() {
		return _values;
	}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		return entrySet();
	}

}
