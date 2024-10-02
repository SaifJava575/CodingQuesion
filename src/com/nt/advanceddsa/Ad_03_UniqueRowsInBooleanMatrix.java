package com.nt.advanceddsa;

import java.util.ArrayList;
import java.util.HashSet;

public class Ad_03_UniqueRowsInBooleanMatrix {

	//T(c)=O(row * col)  AND s(c)=O(row * col)
	public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		HashSet<ArrayList<Integer>> uniqueRowsSet = new HashSet<>();

		for (int i = 0; i < r; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < c; j++) {
				row.add(a[i][j]);
			}

			if (uniqueRowsSet.add(row)) {
				result.add(row);
			}
		}

		return result;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 1, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 } };
		int r=matrix.length;
		int c=matrix[0].length;

		ArrayList<ArrayList<Integer>> uniqueRows = uniqueRow(matrix, r, c);

		for (ArrayList<Integer> row : uniqueRows) {
			System.out.print("$");
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.print("$ ");
		}
	}

}
