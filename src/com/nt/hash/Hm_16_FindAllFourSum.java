package com.nt.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Hm_16_FindAllFourSum {

	// T(C)= O(N3). and S(C)=O(N2)
	public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
		int sum = 0;
		ArrayList<ArrayList<Integer>> u = new ArrayList<>();
		HashSet<String> hs = new HashSet<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int left = j + 1;
				int right = arr.length - 1;
				int ee = arr[i] + arr[j];
				while (left < right) {
					sum = arr[left] + arr[right] + ee;
					if (sum == k) {

						String str = arr[i] + "," + arr[j] + "," + arr[left] + "," + arr[right];
						if (hs.contains(str)) {
							left++;
							right--;
							continue;
						} else
							hs.add(str);

						ArrayList<Integer> al = new ArrayList<>();
						al.add(arr[i]);
						al.add(arr[j]);
						al.add(arr[left]);
						al.add(arr[right]);
						u.add(al);
						left++;
						right--;

					} else if (sum > k)
						right--;
					else
						left++;
				}
			}
		}
		return u;
	}

	public static void main(String[] args) {

		int A[] = { 10, 2, 3, 4, 5, 7, 8 };
		int n = A.length;
		int k = 23;
		ArrayList<ArrayList<Integer>> response = fourSum(A, k);
		System.out.println(response);

	}

}
