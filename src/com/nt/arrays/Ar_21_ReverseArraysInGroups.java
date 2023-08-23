package com.nt.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ar_21_ReverseArraysInGroups {

	//T(C)=O(n) and S(c)=O(1)
	public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
		for (int i = 0; i < n; i += k) {
			int left = i;
			int right = Math.min(i + k - 1, n - 1);
			while (left < right) {
				Collections.swap(arr, left, right);
				left++;
				right--;
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = (ArrayList<Integer>) List.of(1, 2, 3, 4, 5);
		int size = arr.size();
		int k = 3;
		reverseInGroups(arr, size, k);
		System.out.println("The output is::"+arr);

	}

}
