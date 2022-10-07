public class DictEntry<K, V> {
	
	private K key;
	private V value;

	public DictEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K key() {
		return this.key;
	}
	
	public V value() {
		return this.value;
	}
	
	public void changeValue(V newVal) {
		this.value = newVal;
	}
	
	public String toString() {
		return(String.format("(%s , %s)",(String)key, (String)value));
	}
	
}
