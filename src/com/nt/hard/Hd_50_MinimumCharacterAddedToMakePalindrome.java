package com.nt.hard;

public class Hd_50_MinimumCharacterAddedToMakePalindrome {

	// T(C)=O(N) and S(C)=O(1)
	public static int minChar(String str) {
		int ans = 0;
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			} else {
				ans = str.length() - j;
				i = 0;
				while (str.charAt(i) == str.charAt(j)) {
					i++;
					ans--;
				}
				j--;

			}
		}

		return ans;

	}

	public static void main(String[] args) {
		String S = "abcde";
		int response = minChar(S);
		System.out.println("the minnimum character to be addded to make palindrome ::" + response);

	}

}
