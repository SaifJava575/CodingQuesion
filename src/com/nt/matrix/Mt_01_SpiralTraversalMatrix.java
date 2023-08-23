package com.nt.matrix;

import java.util.ArrayList;

public class Mt_01_SpiralTraversalMatrix {

	// T(C)=O(r*c) and S(C)=O(r*c)
	public static ArrayList<Integer> spirallyTraverse(int m[][], int r, int c) {
		ArrayList<Integer> ar = new ArrayList<>();
		int top = 0, bottom = r - 1, left = 0, right = c - 1;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++)
				ar.add(m[top][i]);
			top++;
			if (top > bottom)
				break;

			for (int i = top; i <= bottom; i++)
				ar.add(m[i][right]);
			right--;
			if (left > right)
				break;

			for (int i = right; i >= left; i--)
				ar.add(m[bottom][i]);
			bottom--;

			for (int i = bottom; i >= top; i--)
				ar.add(m[i][left]);
			left++;
		}
		return ar;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int row = 4, col = 4;
		ArrayList<Integer> response = spirallyTraverse(matrix, row, col);
		System.out.println("The Spirally matrix is::" + response);
	}

}
