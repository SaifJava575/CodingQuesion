package com.nt.hash;

import java.util.HashMap;
import java.util.Map;

public class Hm_11_LongestSubArraysWithSumK {

	// T(C)=O(N) and S(C)=O(n)
	public static int lenOfLongSubarr(int A[], int N, int K) {
		int sum = 0;
		int maxLength = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			sum += A[i];
			if (sum == K)
				maxLength = Math.max(maxLength, i + 1);
			if (map.containsKey(sum - K))
				maxLength = Math.max(maxLength, i - map.get(sum - K));
			if (!map.containsKey(sum))
				map.put(sum, i);

		}
		return maxLength;
	}

	public static void main(String[] args) {

		int A[] = { 10, 5, 2, 7, 1, 9 };
		int k = 15;
		int response = lenOfLongSubarr(A, A.length, k);
		System.out.println("Length of the longest Sub Array sum is :" + response);
	}

}
