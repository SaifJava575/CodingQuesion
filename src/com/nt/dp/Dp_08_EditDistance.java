package com.nt.dp;

public class Dp_08_EditDistance {

	public static int editDistance(String s, String t) {
		int n = s.length();
		int m = t.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = i;
		for (int j = 0; j <= m; j++)
			dp[0][j] = j;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int ans = 0;
				if (s.charAt(i - 1) == t.charAt(j - 1))
					ans = dp[i - 1][j - 1];
				else
					ans = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));

				dp[i][j] = ans;
			}

		}
		return dp[n][m];
	}

	public static void main(String[] args) {
    String s="geek",t="gesek";
    int response=editDistance(s, t);
    System.out.println("The edit distance is "+response);
	}

}
