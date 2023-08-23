package com.nt.string;

public class St_10_LongestCommonSubString {

	//T(C)=O(n*m).  and S(C)=O(1)
	public static int longestCommonSubstr(String S1, String S2) {
		int n = S1.length(), m = S2.length();
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int k = 0;
				while ((i + k) < n && (j + k) < m && S1.charAt(i + k) == S2.charAt(j + k)) {
					k = k + 1;
				}
				ans = Math.max(ans, k);
			}
		}
		return ans;
	}

	// Dynamic Problem Solution  T(C)=O(n*m).  and S(C)=O(1)
	public static int longestCommonSubstring(String S1, String S2) {
		int n=S1.length(), m=S2.length();
		int result = 0;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0)
					dp[i][j] = 0;
				else if (j == 0)
					dp[i][j] = 0;
				else if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (result < dp[i][j])
						result = dp[i][j];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "ABCDGH", str2 = "ACDGHR";
		int res = longestCommonSubstring(str, str2);
		System.out.println("The longest Common Substring is::" + res);
	}

}
