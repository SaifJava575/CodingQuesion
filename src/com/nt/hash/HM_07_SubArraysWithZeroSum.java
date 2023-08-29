package com.nt.hash;

import java.util.HashSet;

public class HM_07_SubArraysWithZeroSum {

	public static boolean findsum(int arr[], int n) {
		int prefix = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			prefix += arr[i];
			if (prefix == 0)
				return true;
			else if (set.contains(prefix))
				return true;
			else
				set.add(prefix);
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 2 - 3, 1, 6 };
		if (findsum(arr, arr.length))
			System.out.println("SubArray with Given Sum is true");
		else
			System.out.println("Not Possible ");
	}

}
