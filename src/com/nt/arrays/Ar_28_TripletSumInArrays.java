package com.nt.arrays;

import java.util.HashSet;

public class Ar_28_TripletSumInArrays {

	//T(C)=O(n^2)  and S(C)=O(1)
	public static boolean find3Numbers(int A[], int n, int X) {
		for (int i = 0; i < n - 2; i++) {
			HashSet<Integer> hs = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int cur = X - (A[i] + A[j]);
				if (hs.contains(cur))
					return true;
				else
					hs.add(A[j]);
			}
		}
		return false;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 45, 6, 10, 8 };
		int x=13;
		if(find3Numbers(arr, arr.length, x))
			System.out.println("Exist");
		else 
			System.out.println("Not Exist");
	}

}
