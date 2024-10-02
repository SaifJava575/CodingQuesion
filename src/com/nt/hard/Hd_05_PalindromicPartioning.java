package com.nt.hard;

public class Hd_05_PalindromicPartioning {

	//T(C)= O(n*n)   and S(c)= O(n*n)
	static int palindromicPartition(String str) {
		int n = str.length();
		int dp[] = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			int ans = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) {
				if (isPalindrome(i, j, str)) {
					int cost = 1 + dp[j + 1];
					ans = Math.min(ans, cost);
				}
			}
			dp[i] = ans;
		}
		return dp[0] - 1;
	}

	static boolean isPalindrome(int i, int j, String s) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			else {
				i++;
				j--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "ababbbabbababa";
		int response = palindromicPartition(str);
		System.out.println("Palindromic Partion are ::" + response);

	}

}
