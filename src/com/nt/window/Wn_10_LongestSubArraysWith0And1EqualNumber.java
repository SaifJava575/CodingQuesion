package com.nt.window;

import java.util.HashMap;
import java.util.Map;

public class Wn_10_LongestSubArraysWith0And1EqualNumber {

	// T(C)=O(n) and S(C)=O(n)
	static int maxLen(int[] arr, int N) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, ans = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == 1)
				sum += 1;
			else
				sum -= 1;
			if (sum == 0)
				ans = i + 1;
			if (map.containsKey(sum))
				ans = Math.max(ans, i - map.get(sum));
			else
				map.put(sum, i);
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 0, 1, 0, 0 };
		int n = arr.length;
		int response = maxLen(arr, n);
		System.out.println("Max length is ::" + response);
	}

}
