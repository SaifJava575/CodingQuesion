package com.nt.arrays;

import java.util.ArrayList;

public class Ar_01_SubArrayWithGivenSum {

	// T(C)=O(n) and S(C)=O(1)
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
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
		int N = 5, S = 12;
		int A[] = { 1, 2, 3, 7, 5 };
		ArrayList<Integer> res = subarraySum(A, N, S);
		System.out.println(res);

	}

}
