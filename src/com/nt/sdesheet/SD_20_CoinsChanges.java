package com.nt.sdesheet;

public class SD_20_CoinsChanges {

	public static long count(int coins[], int N, int sum) {
		long[] dp = new long[sum + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= sum; i++) {
				dp[i] += dp[i - coin];
			}
		}
		return dp[sum];
	}

	public static void main(String[] args) {

		int coins[] = { 1, 2, 3 };
		int sum = 4;
		long response = count(coins, coins.length, sum);
		System.out.println("The combination of Coins is ::" + response);
	}

}
