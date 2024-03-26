package com.nt.sdesheet;

import java.util.ArrayList;
import java.util.Collections;

public class SD_03_LeadersInArray {

	// T(C)=O(n) and S(C)=O(n)
	static ArrayList<Integer> leaders(int arr[], int n) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(arr[n - 1]);
		int max = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			if (arr[i] >= max) {
				res.add(arr[i]);
				max = Math.max(max, arr[i]);
			}
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		int A[] = { 16, 17, 4, 3, 5, 2 };
		int n = A.length;
		ArrayList<Integer> response = leaders(A, n);
		System.out.println("The leaders of the element is ::" + response);

	}

}
