package com.nt.hard;

public class Hd_24_NumberOfDistinctSubSequence {

	// T(C)=O(|str|) and S(C)=O(|str|)
	public static int distinctSubsequences(String s) {
		int mod = 1000000007;
		int dp[] = new int[s.length() + 1];
		dp[0] = 1;

		int ch[] = new int[26];

		for (int i = 1; i < dp.length; i++) {
			int val = ch[s.charAt(i - 1) - 'a'];
			dp[i] = ((2 * dp[i - 1]) % mod) - val;
			dp[i] %= mod;
			ch[s.charAt(i - 1) - 'a'] = dp[i - 1];
		}
		int ans = (dp[s.length()] + mod) % mod;
		return ans;
	}

	public static void main(String[] args) {
		String s = "gfg";
		int response = distinctSubsequences(s);
		System.out.println("Number of Distinct Subsequence is ::" + response);

	}

}
