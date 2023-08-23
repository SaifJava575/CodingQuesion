package com.nt.string;

public class St_21_LongestPrefixSuffix {

	//T(C)=O(|s|)  and S(C)=O(|s|)
	public static int lps(String str) {
		int lcp[] = new int[str.length()];
		lcp[0] = 0;
		int i = 0;
		int j = 1;
		while (j < str.length()) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				lcp[j] = i;
				j++;
			} else {
				if (i != 0)
					i = lcp[i - 1];
				else {
					lcp[i] = 0;
					j++;
				}
			}
		}
		return lcp[lcp.length - 1];
	}

	public static int lps1(String s) {
		int n = s.length();
		if (n < 2)
			return 0;
		int i = 0;
		int j = 1;
		while (j < n) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			} else {
				j = j - i + 1;
				i = 0;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		String str = "saifuddsai";
		int res = lps1(str);
		System.out.println("Longest Prefix and Suffix is::" + res);

	}

}
