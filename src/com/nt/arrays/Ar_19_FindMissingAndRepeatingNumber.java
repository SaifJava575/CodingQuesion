package com.nt.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class Ar_19_FindMissingAndRepeatingNumber {

	//T(c)=O(n)  and S(c)=O(n)
	public static int[] findTwoElement(int arr[], int n) {
		int[] count = new int[n + 1];
		Arrays.fill(count, 0);
		for (int x : arr)
			count[x]++;
		int repeating = 0, missing = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0)
				missing = i;
			if (count[i] == 2)
				repeating = i;
		}
		int ans[] = { repeating, missing };
		return ans;
	}
	//T(c)=O(n)  and S(c)=O(n)
	public static int[] findTwoElement1(int arr[], int n) {
		int[] res = new int[2];
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				res[0] = arr[i];
			}
			set.add(arr[i]);
		}

		for (int i = 1; i <= n; i++) {
			if (!set.contains(i))
				res[1] = i;

		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 6, 7, 1, 3 };
		int n = arr.length;
		int[] res = findTwoElement1(arr, n);
		System.out.println("Repeating: " + res[0] + " Missing: " + res[1]);
	}

}
