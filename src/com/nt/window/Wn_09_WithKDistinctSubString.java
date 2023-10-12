package com.nt.window;

public class Wn_09_WithKDistinctSubString {

	//T(c)=O(|S|).  AND S(c)=O(1)
	static long substrCount(String S, int K) {
		return atmost(S, K) - atmost(S, K - 1);
	}

	static long atmost(String s, int k) {
		int arr[] = new int[26];
		int res = 0;
		int left = 0;
		int dist = 0;
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			if (arr[s.charAt(i) - 'a'] == 1)
				dist++;
			while (dist > k) {
				arr[s.charAt(left) - 'a']--;
				if (arr[s.charAt(left) - 'a'] == 0)
					dist--;
				left++;
			}
			res = res + (i - left + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		String S = "abaaca";
		int k = 3;
		long response = substrCount(S, k);
		System.out.println("Distinct SubString is with K character count " + response);

	}

}
