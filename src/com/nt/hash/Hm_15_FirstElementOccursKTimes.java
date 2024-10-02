package com.nt.hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class Hm_15_FirstElementOccursKTimes {

	//T(C)= O(N) and S(c)= O(N)
	public static int firstElementKTime(int[] a, int n, int k) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		int found = -1;
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			if (map.get(a[i]) == k) {
				found = a[i];
				return found;
			}
		}
		return found;
	}

	public static void main(String[] args) {

		int A[] = { 1, 7, 4,1,3, 4, 8, 7, 2 };
		int n = A.length;
		int k = 2;
		int response = firstElementKTime(A, n, k);
		System.out.println("First Occur ELement is ::" + response);

	}

}
