package com.nt.hard;

import java.util.Arrays;

public class Hd_34_AggressiveCows {

	// T(n) = O(nlogn)
	// S(n) = O(1)
	public static int solve(int n, int k, int[] stalls) {
		int start = 1;
		int end = Arrays.stream(stalls).max().getAsInt();
		int ans = -1;
		Arrays.sort(stalls);
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(stalls, k, mid)) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public static boolean isPossible(int arr[], int cows, int distance) {
		int numberOfCows = 1;
		int first = 0;
		for (int i = 1; i < arr.length; i++) {
			int second = i;
			if (arr[i] != 0 && Math.abs(arr[first] - arr[second]) >= distance) {
				numberOfCows++;
				first = second;
			}
		}
		return numberOfCows >= cows;
	}

	public static void main(String[] args) {
		int k = 3;
		int stalls[] = { 10, 1, 2, 7, 5 };
		int response = solve(stalls.length, k, stalls);
		System.out.println("The min distance between two Aggresive cows is ::" + response);
	}

}
