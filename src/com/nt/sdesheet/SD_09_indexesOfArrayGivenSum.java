package com.nt.sdesheet;

import java.util.ArrayList;

public class SD_09_indexesOfArrayGivenSum {

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		int i = 0, j = 0;
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (j < n) {
			sum += arr[j];
			while (sum > s) {
				sum -= arr[i];
				i++;
			}
			if (sum == s) {
				if (i > j)
					break;
				list.add(i + 1);
				list.add(j + 1);
				break;
			}
			j++;
		}
		if (list.isEmpty())
			list.add(-1);
		return list;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 7, 5 };
		int S = 12;
		ArrayList<Integer> list = subarraySum(A, A.length, S);
		System.out.println("The SubArrays Sum is ::" + list);

	}

}
