package com.nt.arrays;

import java.util.ArrayList;

public class Ar_23_MaxAllSubArraysOfSize {

	//T(C)=O(n^2) and S(c)=O(n)
	public static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<n-k+1;i++) {
			int max=arr[i];
			for(int j=i+1;j<i+k;j++) {
				if (max<arr[j])
					max=arr[j];
			}
			list.add(max);	
		}
		return list;
	}

	public static void main(String[] args) {
		int arr[]= {1,2,3,1,4,5,2,3,6};
		ArrayList<Integer> res=max_of_subarrays(arr, arr.length, 3);
		System.out.println("The response is::"+res);

	}

}
