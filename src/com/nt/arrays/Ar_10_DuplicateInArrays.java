package com.nt.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Ar_10_DuplicateInArrays {

	// T(c)=O(n) and S(C)=O(n)
	public static ArrayList<Integer> duplicates(int arr[], int n) {
		Arrays.sort(arr);
		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
		}
		for (Map.Entry<Integer, Integer> val : map.entrySet()) {
			if (val.getValue() > 1)
				list.add(val.getKey());
		}
		if (list.isEmpty())
			list.add(-1);
		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {
		int a[] = { 2, 3, 1, 2, 3 };
		int n = a.length;
		ArrayList<Integer> res = duplicates(a, n);
		System.out.println("Duplicate Element is::" + res);
	}

}
