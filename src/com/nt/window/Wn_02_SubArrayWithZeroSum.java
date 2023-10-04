package com.nt.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Wn_02_SubArrayWithZeroSum {

	// T(C)=O(n) and S(C)=O(n)
	static boolean findsum(int arr[], int n) {
		int sum = 0;
		Set<Integer> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (arr[i] == 0 || sum == 0 || hs.contains(sum))
				return true;
			hs.add(sum);
		}
		return false;
	}

	static boolean findsum1(int arr[], int n) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
			if (arr[i] == 0 || sum == 0 || map.containsKey(sum)) {
				return true;
			}
			map.put(sum, 1);
		}
		return false;

	}

	public static void main(String[] args) {
		int arr[] = { 4, 2, -3, 1, 6 };
		int n = arr.length;
		if (findsum1(arr, n))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
