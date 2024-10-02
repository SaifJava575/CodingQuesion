package com.nt.hard;

import java.util.ArrayList;
import java.util.List;

public class Hd_22_N_QueensProblem {

	//T(c)=O(n!)   AND s(c)=0(n^2)
	public static ArrayList<ArrayList<Integer>> nQueen(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		solveNQueens(n, 0, new ArrayList<>(), result);
		return result;

	}

	private static void solveNQueens(int n, int row, List<Integer> currentPlacement, List<ArrayList<Integer>> result) {
		if (row == n) {
			result.add(new ArrayList<>(currentPlacement));
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isValidPlacement(currentPlacement, row, col)) {
				currentPlacement.add(col + 1); // 1-indexed
				solveNQueens(n, row + 1, currentPlacement, result);
				currentPlacement.remove(currentPlacement.size() - 1);
			}
		}
	}

	private static boolean isValidPlacement(List<Integer> currentPlacement, int row, int col) {
		for (int prevRow = 0; prevRow < row; prevRow++) {
			int prevCol = currentPlacement.get(prevRow) - 1; // 1-indexed
			if (prevCol == col || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> response = nQueen(5);
		System.out.println(response.size());
		for (ArrayList<Integer> val : response)
			System.out.println(val);

	}

}
