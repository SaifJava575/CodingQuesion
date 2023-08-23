package com.nt.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Ar_06_LeadersInArrays {

	public static ArrayList<Integer> leaders(int arr[], int n) {
		ArrayList<Integer> list = new ArrayList<>();
		int max = arr[n - 1];
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] >= max) {
				max = arr[i];
				list.add(max);
			}
		}
		Collections.reverse(list);
		return list;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 0 };
		int n = A.length;
		ArrayList<Integer> res=leaders(A, n);
		System.out.println("Leader of the element is ::"+res);
	}

}
