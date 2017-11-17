package p07;

public class HashNode <K, V> {
	protected K key;
	protected V value;
	HashNode next;
	
	public HashNode (K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

}
