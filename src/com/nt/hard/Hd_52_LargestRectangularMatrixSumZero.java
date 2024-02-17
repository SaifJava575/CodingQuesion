package com.nt.hard;

import java.util.ArrayList;
import java.util.HashMap;

public class Hd_52_LargestRectangularMatrixSumZero {

	public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] b) {
		int m = b.length;
		int n = b[0].length;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int startRow = -1, endRow = -1, startCol = -1, endCol = -1;
		int maxSize = 0;
		for (int l = 0; l < n; l++) {
			int[] rowSum = new int[m];
			for (int r = l; r < n; r++) {
				for (int i = 0; i < m; i++) {
					rowSum[i] += b[i][r];
				}
				int sum = 0;
				HashMap<Integer, Integer> map = new HashMap<>();
				map.put(0, -1);
				for (int i = 0; i < m; i++) {
					sum += rowSum[i];
					if (map.containsKey(sum)) {
						int currentSize = (r - l + 1) * (i - map.get(sum));
						if (currentSize > maxSize) {
							maxSize = currentSize;
							startRow = map.get(sum) + 1;
							endRow = i;
							startCol = l;
							endCol = r;
						}
					} else {
						map.put(sum, i);
					}
				}
			}
		}
		if (maxSize == 0) {
			return ans;
		}
		for (int i = startRow; i <= endRow; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = startCol; j <= endCol; j++) {
				row.add(b[i][j]);
			}
			ans.add(row);
		}
		return ans;
	}

	public static void main(String[] args) {
		int mat[][] = { { 9, 7, 16, 5 }, { 1, -6, -7, 3 }, { 1, 8, 7, 9 }, { 7, -2, 0, 10 } };
		ArrayList<ArrayList<Integer>> response = sumZeroMatrix(mat);
		for (ArrayList<Integer> res : response) {
			for (Integer val : res)
				System.out.print(val + " ");
			System.out.println();
		}
	}
}
