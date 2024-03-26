package com.nt.sdesheet;

import java.util.Arrays;

public class SD_01_ArraySubSetOfAnotherArrays {

	// T(C)=O(max(n,m)) and S(C)= O(n)
	public static String isSubset(long a1[], long a2[], long n, long m) {
		Arrays.sort(a1);
		Arrays.sort(a2);
		int i = 0, j = 0;
		while (i < n && j < m) {
			if (a1[i] == a2[j])
				j += 1;
			i += 1;
		}
		if (j == m)
			return "Yes";
		else
		return "No";
	}

	public static void main(String[] args) {
		long a1[] = { 11, 7, 1, 13, 21, 3, 7, 3 };
		long n = a1.length;
		long a2[] = { 11, 3, 7, 1, 7 ,8};
		long m = a2.length;
		String response = isSubset(a1, a2, n, m);
		System.out.println("Result is ::" + response);
	}

}
