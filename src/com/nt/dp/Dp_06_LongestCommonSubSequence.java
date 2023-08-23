package com.nt.dp;

import java.util.ArrayList;
import java.util.List;

public class Dp_06_LongestCommonSubSequence {

	public static int lcs(int x, int y, String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		List<Character> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < x; i++)
			list.add(c1[i]);
		for (int j = 0; j < y; j++) {
			if (list.contains(c2[j]))
				count++;
		}
		return count;
	}

	public static int lcs1(int x, int y, String s1, String s2) {
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				int ans = 0;
				if (s1.charAt(i) == s2.charAt(j)) 
					ans = 1 + dp[i + 1][j + 1];
				 else 
					ans = Math.max(dp[i][j + 1], dp[i + 1][j]);
				
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {

		String str1 = "ABCDGH", str2 = "AEDFHR";
		int response = lcs1(str1.length(), str2.length(), str1, str2);
		System.out.println("Longest Common SubSequence is::" + response);
	}

}
