package com.nt.hard;

import java.util.ArrayList;
import java.util.List;

public class Hd_35_CountSmallestElement {

	// T(C)=O(N*logN) and S(C)=O(N)
	static int[] constructLowerArray(int[] a, int n) {
		int ans[] = new int[n];
		int x = n - 2;
		List<Integer> arr = new ArrayList<>();
		arr.add(a[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			int idx = dfs(arr, a[i], 0, arr.size() - 1);
			arr.add(idx, a[i]);
			ans[x] = idx;
			x--;

		}
		return ans;
	}

	static int dfs(List<Integer> arr, int key, int l, int h) {
		if (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr.get(mid) >= key) {
				return dfs(arr, key, l, mid - 1);
			} else {
				return dfs(arr, key, mid + 1, h);
			}
		}
		return l;
	}

	public static void main(String[] args) {
		int arr[] = { 12, 1, 2, 3, 0, 11, 4 };
		int n = arr.length;
		int response[] = constructLowerArray(arr, n);
		System.out.println("constrauct The Array element of the right side of the each Element");
		for (int i : response) {
			System.out.print(i + " ");
		}

	}

}
