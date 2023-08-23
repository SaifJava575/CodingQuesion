package com.nt.arrays;

public class Ar_26_RotateArrays {

	static void rotateArr(int arr[], int d, int n) {
		d = d % n;
		int h = 0;
		int b[] = new int[n];
		for (int i = d; i < n; i++)
			b[h++] = arr[i];
		for (int i = 0; i < d; i++)
			b[h++] = arr[i];

		for (int i = 0; i < n; i++)
			arr[i] = b[i];

	}

	public static void main(String[] args) {
    int arr[]= {1,2,3,4,5,6};
    rotateArr(arr, 2, arr.length);
    for(int i=0;i<arr.length;i++)
    	System.out.print(arr[i]+" ");
	}

}
