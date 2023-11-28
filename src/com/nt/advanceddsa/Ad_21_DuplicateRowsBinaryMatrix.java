package com.nt.advanceddsa;

import java.util.ArrayList;
import java.util.HashSet;

public class Ad_21_DuplicateRowsBinaryMatrix {

	//T(C)=O(R * C)   and S(C)=O(R * C)
	public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				arr.add(matrix[i][j]);
			}
			if (set.contains(arr))
				ans.add(i);
			else
				set.add(arr);
		}
		return ans;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 0, 0, 0 } };
		int m = matrix.length;
		int n = matrix[0].length;
		ArrayList<Integer> response = repeatedRows(matrix, m, n);
		System.out.println("Duplicate Rows is ::" + response);

	}

}
