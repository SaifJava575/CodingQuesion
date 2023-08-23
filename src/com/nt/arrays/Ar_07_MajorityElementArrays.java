package com.nt.arrays;

import java.util.HashMap;
import java.util.Map;

public class Ar_07_MajorityElementArrays {

	// T(C)=o(n) AND s(C)=o(1)

	public static int majorityElement(int arr[], int size) {
		int max = size / 2, ans = -1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
			if (max < map.get(arr[i])) {
				max = map.get(arr[i]);
				ans = arr[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int A[] = { 3, 1, 3, 3, 2 };
		int res = majorityElement(A, A.length);
		System.out.println("The majority element is::" + res);
	}

}
