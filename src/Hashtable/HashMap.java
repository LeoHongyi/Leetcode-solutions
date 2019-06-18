package Hashtable;

public class HashMap {
	private class Node {
		String val;
		Node next;
	}
	private Node[] data;
	private int size;
	private int used;

	public HashMap() {
		data = new Node[10];
		size = 10;
		used = 0;
	}
	public void put(String key, int value) {
		int index = key.hashCode() % size;
		data[index] = push_front(data[index], key,val);
		used++;
		if (used >= size / 2) {
			//resize and rehash
			rehash(size * 2);
			size *= 2;
		}
	}
	public String get(String key) {
		int index = key.hashCode() % size;
		return searchValue(data[index], key);
	}
	private void rehash(int newSize) {
		Node[] oldData =
	}
}
