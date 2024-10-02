package com.nt.hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;

class Node {
	int key, value;

	Node(int k, int v) {
		key = k;
		value = v;
	}
}

class LRUCache {
	// Constructor for initializing the cache capacity with the given value.
	static LinkedHashMap<Integer, Integer> lhm;
	static int capa;

	LRUCache(int cap) {
		lhm = new LinkedHashMap<>(cap);
		capa = cap;
	}

	// Function to return value corresponding to the key.
	public static int get(int key) {
		int a = lhm.getOrDefault(key, -1);
		if (a != -1) {
			lhm.remove(key);
			lhm.put(key, a);
		}
		return a;
	}

	// Function for storing key-value pair.
	public static void set(int key, int value) {
		if (lhm.size() < capa) {
			lhm.put(key, value);
		} else {
			if (lhm.containsKey(key)) {
				lhm.remove(key);
				lhm.put(key, value);
			} else {
				ArrayList<Integer> arr = new ArrayList<>(lhm.keySet());
				int a = arr.get(0);
				lhm.remove(a);
				lhm.put(key, value);
			}
		}
	}
}

public class Hm_18_LRUCacheDesign {

	public static void main(String[] args) {

	}

}
