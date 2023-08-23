package com.nt.matrix;

public class Mt_07_FloodFillAlgorithm {

	//T(c)=O(n*m)  and S(C)=O(n*m)
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int target = image[sr][sc];
		int dp[][] = new int[image.length][image[0].length];
		fill(image, sr, sc, target, newColor, dp);
		return image;
	}

	private static void fill(int arr[][], int r, int c, int tar, int newTar, int dp[][]) {
		if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length) {
			return;
		}
		if (arr[r][c] == tar && dp[r][c] == 0) {
			dp[r][c] = -1;
			arr[r][c] = newTar;
			fill(arr, r + 1, c, tar, newTar, dp);
			fill(arr, r - 1, c, tar, newTar, dp);
			fill(arr, r, c + 1, tar, newTar, dp);
			fill(arr, r, c - 1, tar, newTar, dp);
		}
	}

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, newColor = 2;
		int response[][] = floodFill(image, sr, sc, newColor);
		
		for (int i = 0; i < response.length; i++) {
			for (int j = 0; j < response[0].length; j++) {
				System.out.print(response[i][j] + " ");
			}
			System.out.println();
		}
	}

}
