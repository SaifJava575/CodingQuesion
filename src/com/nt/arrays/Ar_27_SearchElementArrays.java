package com.nt.arrays;

public class Ar_27_SearchElementArrays {

	//T(c)=O(n) and S(C)=O(1)
	public static int search(int arr[], int N, int X) {

		for (int i = 0; i < N; i++) {
			if (arr[i] == X)
				return i;
		}
		return -1;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int x = 7;
		int response = search(arr, arr.length, x);
		System.out.println("The Search Element is::" + response);
	}

}
