package com.nt.arrays;

import java.util.HashSet;

public class Ar_29_SmallestPositiveMissingNumber {

	//T(C)=O(n)  and S(c)=O(1)
	public static int missingNumber(int arr[], int size) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < size; i++)
			hs.add(arr[i]);
		for (int i = 0; i < size; i++) {
			if (!hs.contains(i))
				return i;
		}
		return size + 1;
	}

	public static void main(String[] args) {
		int arr[] = { 0, -10, 1, 3, -20 };
		int n = arr.length;
		int response=missingNumber(arr, n);
		System.out.println("The smallest positive missing number is::"+response);
	}

}
