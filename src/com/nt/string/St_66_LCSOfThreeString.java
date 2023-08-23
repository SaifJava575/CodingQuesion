package com.nt.string;

public class St_66_LCSOfThreeString {

	// T(c)=O(n1*n2*n3). AND s(c)=O(n1*n2*n3).
	public static int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
		int[][][] arr = new int[n1 + 1][n2 + 1][n3 + 1];

		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				for (int k = 0; k <= n3; k++) {
					if (i == 0 || j == 0 || k == 0) {
						arr[i][j][k] = 0;
					} else if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1)) {
						arr[i][j][k] = 1 + arr[i - 1][j - 1][k - 1];
					} else {
						arr[i][j][k] = Math.max(Math.max(arr[i - 1][j][k], arr[i][j - 1][k]), arr[i][j][k - 1]);
					}
				}
			}
		}
		return arr[n1][n2][n3];

	}

	public static void main(String[] args) {
		String A = "geeks", B = "geeksfor", C = "geeksforgeeks";
		int res = LCSof3(A, B, C, A.length(), B.length(), C.length());
		System.out.println("Longest of three subString length is::" + res);

	}

}
