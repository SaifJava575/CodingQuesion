package com.nt.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HM_06_ArraySubSetOfAnotherArrays {

	public static String isSubset(long a1[], long a2[], long n, long m) {
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < a1.length; i++)
			list.add(a1[i]);
		int count = 0;
		for (int j = 0; j < a2.length; j++) {
			if (list.contains(a2[j]))
				count++;
		}
		if (count == a2.length)
			return "Yes";
		return "No";
	}

	public static String isSubset1(long a1[], long a2[], long n, long m) {
		Arrays.sort(a1);
		Arrays.sort(a2);
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (a1[i] == a2[j]) {
				j++;
			}
			i++;
		}
		return j == m ? "Yes" : "No";
	}

	public static void main(String[] args) {
		long a1[] = { 11, 7, 1, 13, 21, 3, 7, 3 };
		long a2[] = { 11, 3, 7, 1, 7 };
		String response = isSubset1(a1, a2, a1.length, a2.length);
		System.out.println("Arrays subset of Another Arrays:" + response);

	}

}
