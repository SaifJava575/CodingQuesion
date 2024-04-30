package com.nt.sdesheet;

public class SD_21_MinimumAllocationNumberOfPages {

	private static boolean isPossible(int[] pages, int n, int m, int maxPagesPerStudent) {
		int sum = 0;
		int numStudent = 0;
		for (int i = 0; i < n; i++) {
			if (pages[i] > maxPagesPerStudent)
				return false;
			if (sum + pages[i] > maxPagesPerStudent) {
				numStudent++;
				sum = pages[i];
			} else
				sum += pages[i];
		}
		if (sum != 0)
			numStudent++;
		return numStudent <= m;
	}

	// T(C)=O(N) and S(C)=O(1)
	// Function to find minimum number of pages.
	public static int findPages(int[] A, int N, int M) {
		if (M > N)
			return -1;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i];
			max = Math.max(max, A[i]);
		}
		int low = max;
		int high = sum;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPossible(A, N, M, mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	public static void main(String[] args) {
		int A[] = { 12, 34, 67, 90 };
		int M = 2;
		int response = findPages(A, A.length, M);
		System.out.println("Min number of Student Allocated this book is ::" + response);
	}

}
