package com.nt.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class Hm_22_DistinctElementEveryWindow {

	// T(C)=O(n) and S(C)=O(n)
	public static ArrayList<Integer> countDistinct(int A[], int n, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> h = new HashMap<>();
		int count = 0;
		int tmp = -1;
		for (int i = 0; i < A.length; i++) {
			h.put(A[i], h.getOrDefault(A[i], 0) + 1);
			count++;
			if (count == k) {
				res.add(h.size());
				tmp = tmp + 1;
				if (h.get(A[tmp]) == 1)
					h.remove(A[tmp]);
				else
					h.put(A[tmp], h.get(A[tmp]) - 1);
				count--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 1, 3, 4, 2, 3 };
		int n = A.length;
		int k = 4;
		ArrayList<Integer> response = countDistinct(A, n, k);
		System.out.println("Distinct Element in every window size is::" + response);

	}

}
