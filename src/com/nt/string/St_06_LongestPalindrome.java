package com.nt.string;

public class St_06_LongestPalindrome {

	static String longestPalin(String S) {
		if (S.length() == 1)
			return S;
		// int index = 0;
		String st = "";
		for (int i = S.length(); i > 0; i--) {
			for (int j = 0; j < S.length() - i + 1; j++) {
				st = S.substring(j, i + j);
				if (palindromeCheck(st))
					return st;
			}
		}
		return "";
	}

	static String longestPalin2(String s) {
		int max = 0;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			String ans = "";
			for (int j = i; j < s.length(); j++) {
				ans = ans + s.charAt(j);
				int l = ans.length();
				if (l > max) {
					if (palindromeCheck(ans)) {
						max = l;
						res = ans;
					}
				}
			}
		}
		return res;
	}

	private static boolean palindromeCheck(String str) {
		int left = 0, right = str.length() - 1;
		char[] arr = str.toCharArray();
		while (left < right) {
			if (arr[left] != arr[right])
				return false;
			left++;
			right--;
		}
		return true;
	}

	static String longestPalin1(String s) {
		String ans = "";
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < s.length(); i++, j++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j))
						dp[i][j] = true;
					else
						dp[i][j] = false;
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true)
						dp[i][j] = true;
				}
				int length = g + 1;
				if (dp[i][j] && length > ans.length())
					ans = s.substring(i, j + 1);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		String str = "madam";
		String ans = longestPalin2(str);
		System.out.println("Longest Palindrome is::" + ans);
	}

}
