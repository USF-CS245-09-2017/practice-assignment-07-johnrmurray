package p07;

public class Hashtable<K,V> {
	
	private int size;
	private HashNode<K, V>[] arr;
	
	public Hashtable() {
		size = 0;
		arr = new HashNode[314527];
	}
	
	public V get(K key)  {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode start = arr[position];
		while (start != null) {
			if (start.key == key) {
				return (V) start.value;
			} else {
				start = start.next;
			}
		}
		return null;
	}
	
	public void put(K key, V value) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode head = arr[position];
		HashNode start = new HashNode<K,V>(key, value);
		start.next = head;
		arr[position] = start;
		size++;
	}
	
	public V remove(K key) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode head = arr[position];
		if (head == null) {
			return null;
		}
		if (head.key == key) {
			arr[position] = head.next;
			size--;
			return (V) head.value;
		} 
		HashNode previous = head;
		while (head != null) {
			if (head.key == null) {
				previous.next = head.next;
				size--;
			}
			previous = head;
			head = head.next;
		}
		return null;
	}
	
	public boolean containsKey(K key) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode start = arr[position];
		
		while (start != null) {
			if (start.key.equals(key)) {
				return true;
			} else {
				start = start.next;
			}
		}
		return false;
	}
}
