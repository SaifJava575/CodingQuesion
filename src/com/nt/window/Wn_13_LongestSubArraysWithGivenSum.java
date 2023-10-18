package com.nt.window;

import java.util.HashMap;
import java.util.Map;

public class Wn_13_LongestSubArraysWithGivenSum {

	// T(C)=O(n) and S(C)=O(N)
	public static int longSubarrWthSumDivByK(int a[], int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int sum = 0, max = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			int mod = ((sum % k) + k) % k;
			if (mod == 0)
				max = i + 1;
			else if (map.containsKey(mod)) {
				int len = i - map.get(mod);
				max = Math.max(len, max);
			} else
				map.put(mod, i);
		}
		return max;
	}

	public static void main(String[] args) {
		int A[] = { 2, 7, 6, 1, 4, 5 };
		int n = A.length;
		int K = 3;
		int response = longSubarrWthSumDivByK(A, n, K);
		System.out.println("Longest SubArrays with SumDivisible by K " + response);
	}

}
