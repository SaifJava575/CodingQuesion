package com.nt.hash;

import java.util.HashMap;

public class Hm_08_KeyPairSum {

	//T(C)=O(n) and S(c)=O(N)
	public static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i =0; i < arr.length; i++) {
			int diff = x - arr[i];
			if (map.containsKey(diff))
				return true;
			else
				map.put(arr[i], 1);
		}
		return false;
	}

	public static void main(String[] args) {
		int Arr[] = { 1, 4, 45, 6, 10, 8 };
		int n = Arr.length;
		int X = 15;
		if (hasArrayTwoCandidates(Arr, n, X))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
