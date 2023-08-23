package com.nt.matrix;

public class Mt_11_BooleanMatrix {

	public static void booleanMatrix(int mat[][]) {
		int r = mat.length, c = mat[0].length;
		int row[] = new int[r];
		int col[] = new int[c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (mat[i][j] == 1) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (row[i] == 1 || col[j] == 1)
					mat[i][j] = 1;
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 0, 0, 0 } };
		booleanMatrix(matrix);
		
	}

}
