package com.nt.window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Wn_12_Ipl2021MatchDayAnalysis {

	//T(C)=O(n)  and S(C)=O(N)
	static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			while (!dq.isEmpty() && dq.getFirst() <= i - k)
				dq.pollFirst();
			while (!dq.isEmpty() && arr[dq.getLast()] <= arr[i])
				dq.pollLast();
			dq.addLast(i);
			if (i >= k - 1)
				ans.add(arr[dq.peekFirst()]);
		}
		return ans;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int n = arr.length;
		int k = 3;
		ArrayList<Integer> response = max_of_subarrays(arr, n, k);
		System.out.println(response);

	}

}
