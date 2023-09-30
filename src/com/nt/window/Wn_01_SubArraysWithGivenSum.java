package com.nt.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wn_01_SubArraysWithGivenSum {

	// T(C)=O(N) and S(C)=O(1)
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0, -1);
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (map.containsKey(sum - s)) {
				list.add(map.get(sum - s) + 2);
				list.add(i + 1);
				return list;
			}
			map.put(sum, i);
		}
		list.add(-1);
		return list;
	}

	static ArrayList<Integer> subarraySum1(int[] arr, int n, int s) {
		// Your code here

		ArrayList<Integer> a = new ArrayList<>();
		int sum = 0;
		int i, j;
		i = j = 0; // Set two pointers i,j to the 1st position
		while (j < n) {
			sum += arr[j];
			while (sum > s) {
				sum -= arr[i];
				i++;
			}
			if (sum == s) {
				if (i > j)
					break;
				a.add(i + 1);
				a.add(j + 1);
				break;
			}
			j++;
		}
		if (a.isEmpty())
			a.add(-1);
		return a;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 7, 5 };
		int n = A.length;
		int s = 12;
		ArrayList<Integer> response = subarraySum1(A, n, s);
		System.out.println("The expected Output is ::" + response);
	}

}
