package com.nt.arrays;

public class Ar_11_equilibriumPointInArrays {

	public static int equilibriumPoint(int arr[], int n) {
		int sum = 0;
		int leftSum = 0, rightSum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		for (int i = 0; i < n; i++) {
			sum = sum - arr[i];
			rightSum = sum;
			if (leftSum == rightSum)
				return i + 1;
			leftSum += arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int A[] = { 1, 3, 5, 2, 2 };
		int n = A.length;
		int res = equilibriumPoint(A, n);
		System.out.println("Equilibrium point of the position is::" + res);

	}

}
