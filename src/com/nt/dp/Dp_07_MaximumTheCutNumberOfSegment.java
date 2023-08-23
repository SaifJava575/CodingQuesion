package com.nt.dp;

public class Dp_07_MaximumTheCutNumberOfSegment {

	public static int maximizeCuts(int n, int x, int y, int z) {
		int dp[] = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			dp[i] = -1;
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == -1)
				continue;
			if (i + x <= n)
				dp[i + x] = Math.max(dp[i + x], dp[i] + 1);
			if (i + y <= n)
				dp[i + y] = Math.max(dp[i + y], dp[i] + 1);
			if (i + z <= n)
				dp[i + z] = Math.max(dp[i + z], dp[i] + 1);
		}
		if (dp[n] == -1)
			dp[n] = 0;
		return dp[n];
	}

	public static void main(String[] args) {
		int N = 4;
		int x = 2, y = 1, z = 1;
		int response=maximizeCuts(N, x, y, z);
		System.out.println("The maxmum cut is "+response);
	}

}
