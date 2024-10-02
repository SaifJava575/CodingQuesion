package com.nt.amazon;

import java.util.ArrayList;

public class Am_01_ValueEqualToIndex {

	public static ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
		ArrayList<Integer> response=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(arr[i]==i+1)
				response.add(i+1);
		}
		return response;
	}

	public static void main(String[] args) {
		int arr[] = { 15, 2, 45, 12, 7 };
		int n = arr.length;
		ArrayList<Integer> response=valueEqualToIndex(arr, n);
		System.out.println("The value index value is ::"+response);

	}

}
