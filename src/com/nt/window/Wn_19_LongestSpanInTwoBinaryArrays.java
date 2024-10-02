package com.nt.window;

import java.util.HashMap;
import java.util.Map;

public class Wn_19_LongestSpanInTwoBinaryArrays {

	//T(C)=O(n)  and S(C)=O(n)
	static int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int curr = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			curr += (arr1[i] ? 1 : 0) - (arr2[i] ? 1 : 0);
			if (curr == 0)
				ans = i + 1;
			if (map.containsKey(curr))
				ans = Math.max(ans, i - map.get(curr));
			else
				map.put(curr, i);
		}
		return ans;
	}

	public static void main(String[] args) {
		// int arr1[] = { 0, 1, 0, 0, 0, 0 };
		// int arr2[] = { 1, 0, 1, 0, 0, 1 };
		boolean arr1[] = { false, true, false, false, false, false };
		boolean arr2[] = { true, false, true, false, false, true };
		int n = arr1.length;
		int response = longestCommonSum(arr1, arr2, n);
		System.out.println(response);
	}

}
