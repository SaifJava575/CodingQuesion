package com.nt.dp;

import org.bouncycastle.util.Arrays;

public class Dp_11_LongestCommonSubString {

	//T(c)= O(n*m).  and S(C)= O(n*m).
	public static int longestCommonSubstr(String S1, String S2, int n, int m) {
		int dp[][]=new int[n+1][m+1];
		for(int i[]:dp)
			Arrays.fill(i, 0);
		int max=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++)
				if(S1.charAt(i-1)==S2.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
					max=Math.max(max,dp[i][j]);
				}else 
					dp[i][j]=0;			
		}
		return max;
	}

	public static void main(String[] args) {
		String S1 = "ABCDGH", S2 = "ACDGHR";
		int n = S1.length(), m = S2.length();
		int response=longestCommonSubstr(S1, S2, n, m);
		System.out.println("The longest Common SubString is ::"+response);

	}

}
