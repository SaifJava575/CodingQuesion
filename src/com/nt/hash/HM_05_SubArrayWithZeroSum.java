package com.nt.hash;

import java.util.HashMap;

public class HM_05_SubArrayWithZeroSum {

	//T(c)=O(N)  AND S(C)=O(N)
	public static boolean findsum(int arr[], int n) {
		HashMap<Integer, Integer> mp = new HashMap<>();
		int sum = 0;
		for (int i : arr) {
			sum += i;
			if (sum == 0 || mp.containsKey(sum)) {
				return true;
			}
			mp.put(sum, i);
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 15, -2, 8, 1, 7, 10, 23 };
		int n = arr.length;
		if(findsum(arr, n))
			System.out.println("SubArrays With Zero Sum");
		else 
			System.out.println("SubArrays WIth not Zero Sum");
	}

}
