package com.nt.hash;

import java.util.HashMap;

public class HM_04_LargestSubArrayWithZeroSum {

	//T(c)=O(N)  AND S(C)=O(N)
	public static int maxLen(int arr[], int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0)
				maxLen = Math.max(maxLen, i + 1);
			if (map.containsKey(sum))
				maxLen = Math.max(maxLen, i - map.get(sum));
			else
				map.put(sum, i);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int n = arr.length;
		int response = maxLen(arr, n);
		System.out.println("The maximum SubArray is ::" + response);

	}

}
