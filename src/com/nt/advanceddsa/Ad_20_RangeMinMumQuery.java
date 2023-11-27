package com.nt.advanceddsa;

public class Ad_20_RangeMinMumQuery {
	static int st[];

	public static int[] constructST(int arr[], int n) {
		st = new int[4 * n];
		build(arr, 0, n - 1, 0);
		return st;
	}

	public static void build(int[] arr, int s, int e, int ind) {
		if (s == e) {
			st[ind] = arr[s];
			return;
		}
		int m = (s + e) / 2;
		build(arr, s, m, 2 * ind + 1);
		build(arr, m + 1, e, 2 * ind + 2);

		st[ind] = Math.min(st[2 * ind + 1], st[2 * ind + 2]);
	}

	public static int query(int s, int e, int l, int r, int ind) {
		if (s >= l && e <= r)
			return st[ind];

		if (e < l || s > r) {
			return Integer.MAX_VALUE;
		}

		int m = (s + e) / 2;
		return Math.min(query(s, m, l, r, 2 * ind + 1), query(m + 1, e, l, r, 2 * ind + 2));

	}

	/*
	 * The functions returns the min element in the range from l and r
	 */
	public static int RMQ(int st[], int n, int l, int r) {
		return query(0, n - 1, l, r, 0);
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		int length=arr.length;
		int response[]=constructST(arr, length);
		for(int val:response)
			System.out.print(val+" ");
		int res=RMQ(response,response.length, 0, response.length-1);
		System.out.println(res);
	}
}
