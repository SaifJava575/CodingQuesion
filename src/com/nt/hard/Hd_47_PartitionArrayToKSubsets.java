package com.nt.hard;

import java.util.Arrays;

public class Hd_47_PartitionArrayToKSubsets {

	public static boolean isKPartitionPossible(int a[], int n, int k) {
		int sm = 0;
		for (int i : a) {
			sm += i;
		}
		if (sm % k != 0)
			return false;
		sm /= k;
		Arrays.sort(a);
		return helper(a, a.length - 1, k, 0, sm, new boolean[a.length]);
	}

	public static boolean helper(int a[], int n, int k, int csm, int sum, boolean vis[]) {
		if (k == 0)
			return true;
		if (csm == sum)
			return helper(a, a.length - 1, k - 1, 0, sum, vis);
		for (int i = n; i >= 0; i--) {
			if (vis[i])
				continue;
			if (i + 1 < a.length && a[i] == a[i + 1] && !vis[i + 1])
				continue;
			if (csm + a[i] > sum)
				continue;
			vis[i] = true;
			if (helper(a, i - 1, k, csm + a[i], sum, vis))
				return true;
			vis[i] = false;
		}
		return false;
	}

	public static void main(String[] args) {
		int a[] = { 2, 1, 4, 5, 6 };
		int n = a.length;
		int k = 3;
		if (isKPartitionPossible(a, n, k))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
