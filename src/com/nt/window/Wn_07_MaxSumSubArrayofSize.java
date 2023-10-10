package com.nt.window;

import java.util.ArrayList;

public class Wn_07_MaxSumSubArrayofSize {

	// T(C)=O(n) and S(C)=O(1)
	public static long maximumSumSubarray(int k, ArrayList<Integer> Arr, int N) {
		int i = 0, j = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		while (j < N) {
			sum += Arr.get(j);
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				max = Math.max(max, sum);
				sum -= Arr.get(i);
				i++;
				j++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(100);
		arr.add(200);
		arr.add(300);
		arr.add(500);
		int k = 2;
		long response = maximumSumSubarray(k, arr, arr.size());
		System.out.println("Maximum Sum SubArray is ::" + response);

	}

}
