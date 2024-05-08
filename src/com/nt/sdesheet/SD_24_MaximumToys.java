package com.nt.sdesheet;

import java.util.Arrays;

public class SD_24_MaximumToys {

	// T(C)=O(n*logN) and S(C)=O(N)
	static int toyCount(int N, int K, int arr[]) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > K || K <= 0)
				break;
			else {
				count++;
				K -= arr[i];
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int K = 50;
		int arr[] = { 1, 12, 5, 111, 200, 1000, 10 };
		int N = arr.length;
		int response = toyCount(N, K, arr);
		System.out.println("Max toys will be count are ::" + response);

	}

}
