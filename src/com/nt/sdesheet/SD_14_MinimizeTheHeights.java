package com.nt.sdesheet;

import java.util.Arrays;

public class SD_14_MinimizeTheHeights {

	// T(C)=O(n*log*n) and S(c)=O(1)
	static int getMinDiff(int[] arr, int n, int k) {
		Arrays.sort(arr);
		int mini = arr[0] + k;
		int maxim = arr[n - 1] - k;
		int ans = arr[n - 1] - arr[0];

		int mi = 0, ma = 0;

		for (int i = 1; i < n; i++) {
			if (arr[i] - k < 0)
				continue;

			mi = Math.min(arr[i] - k, mini);
			ma = Math.max(arr[i - 1] + k, maxim);
			ans = Math.min(ans, ma - mi);
		}
		return ans;
	}

	public static void main(String[] args) {
		int Arr[] = { 3, 9, 12, 16, 20 };
		int n = Arr.length;
		int k = 3;
		int response = getMinDiff(Arr, n, k);
		System.out.println("The min diff b/w two Tower is ::" + response);

	}

}
