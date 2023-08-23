package com.nt.arrays;

import java.util.HashMap;

public class Ar_16_CountPairsWithGivenSum {

	//T(C)=O(n)  and S(C)=O(n)
	public static int getPairsCount(int[] arr, int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(k - arr[i]))
				count += map.get(k - arr[i]);
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 7, 1 };
		int n = arr.length;
		int k = 6;
		int res = getPairsCount(arr, n, k);
		System.out.println("Pair count is::" + res);
	}

}
