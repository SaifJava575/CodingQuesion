package com.nt.sdesheet;

public class SD_02_MissingNumberArray {

	// T(C)= O(N) and S(C)=O(1)
	static int missingNumber(int array[], int n) {
		int sum = 0;
		for (int i = 0; i < array.length; i++)
			sum += array[i];
		int result = n * (n + 1) / 2;
		int missingNumber = result - sum;
		return missingNumber;
	}

	public static void main(String[] args) {
		int A[] = { 6, 1, 2, 8, 3, 4, 7, 10, 5 };
		int response = missingNumber(A, A.length + 1);
		System.out.println("Missing Number in An Array is::" + response);

	}

}
