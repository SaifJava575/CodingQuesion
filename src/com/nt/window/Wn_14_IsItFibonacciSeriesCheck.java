package com.nt.window;

import java.util.ArrayList;
import java.util.List;

public class Wn_14_IsItFibonacciSeriesCheck {

	static long solve(int n, int k, ArrayList<Long> arr) {
		long sum = 0;
		List<Long> ans = new ArrayList<>();
		for (long x : arr) {
			sum += x;
			ans.add(x);
		}
		int start = 0;

		while (ans.size() < n) {
			ans.add(sum);
			sum += sum;
			sum -= ans.get(start);
			start++;
		}
		return ans.get(n - 1);
	}

	public static void main(String[] args) {

		int GeekNum[] = { 0, 1, 2 };
		//int GeekNum[] = {4};
		ArrayList<Long> list = new ArrayList<>();
		for (int i = 0; i < GeekNum.length; i++)
			list.add((long) GeekNum[i]);
		int N = list.size();
		int K = 1;

		long response = solve(N, K, list);
		System.out.println(response);

	}

}
