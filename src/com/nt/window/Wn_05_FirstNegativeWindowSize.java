package com.nt.window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Wn_05_FirstNegativeWindowSize {

	// T(C)=O(n) and S(C)=O(1)
	public static long[] printFirstNegativeInteger(long A[], int N, int K) {
		long[] ar = new long[N - K + 1];
		for (int i = 0; i < N - K + 1; i++) {
			for (int j = i; j < i + K; j++) {
				long n = A[j];
				if (n < 0) {
					ar[i] = n;
					break;
				}
			}
		}
		return ar;
	}

	public static long[] printFirstNegativeInteger1(long A[], int N, int K) {
		ArrayList<Long> list = new ArrayList<>();
		for (int i = 0; i <= N - K; i++) {
			boolean isFound = false;
			for (int j = i; j < i + K; j++) {
				if (A[j] < 0) {
					isFound = true;
					list.add(A[j]);
					break;
				}
			}
			if (!isFound) {
				list.add(0L);
			}
		}
		long arr[] = new long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static long[] printFirstNegativeInteger2(long A[], int N, int k) {
		Queue<Long> q = new LinkedList<>();
		long res[] = new long[N + 1 - k];
		for (int i = 0; i < k; i++) {
			if (A[i] < 0) {
				q.offer(A[i]);
			}
		}
		int low = 0;
		for (int i = k; i < N + 1; i++) {

			if (q.isEmpty())
				res[low] = 0;
			else {
				if (q.peek() == A[low])
					res[low] = q.poll();
				else
					res[low] = q.peek();
			}
			if (i < N && A[i] < 0)
				q.offer(A[i]);
			low++;

		}
		return res;
	}

	public static void main(String[] args) {
		long arr[] = { -8, 2, 3, -6, 10 };
		int n = arr.length;
		int windowSize = 2;
		long response[] = printFirstNegativeInteger2(arr, n, windowSize);
		for (long val : response) {
			System.out.print(val + " ");
		}
	}

}
