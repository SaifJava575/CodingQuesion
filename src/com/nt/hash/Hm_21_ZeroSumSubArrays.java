package com.nt.hash;

import java.util.HashMap;

public class Hm_21_ZeroSumSubArrays {

	// T(C)= O(n*log(n)) and S(C)=O(n)
	public static long findSubarray(long[] arr, int n) {
		HashMap<Long, Integer> map = new HashMap<>();
		long sum = 0;
		long ans = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0)
				ans++;
			if (map.containsKey(sum)) {
				ans += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else
				map.put(sum, 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		long arr[] = { 6, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		int n = arr.length;
		long response = findSubarray(arr, n);
		System.out.println("Count of the Sub Arrays is :" + response);
	}

}
