package com.nt.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Wn_18_EquivalentSubArrays {

	// T(C)= O(N). and S(C)= O(N).
	static int countDistinctSubarray(int arr[], int n) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++)
			set.add(arr[i]);
		Map<Integer, Integer> mp = new HashMap<>();
		int i = 0, j = 0, cnt = 0;
		while (i <= j && j<n) {
			mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1);
			while (mp.size() == set.size()) {
				cnt += (n - j);
				mp.put(arr[i], mp.get(arr[i]) - 1);
				if (mp.get(arr[i]) == 0)
					mp.remove(arr[i]);
				i++;
			}
			j++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 1, 3, 2, 3 };
		int n = arr.length;
		int response = countDistinctSubarray(arr, n);
		System.out.println("Count Distinct SubArrays is " + response);

	}

}
