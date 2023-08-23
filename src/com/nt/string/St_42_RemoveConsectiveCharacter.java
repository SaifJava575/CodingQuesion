package com.nt.string;

public class St_42_RemoveConsectiveCharacter {

	//T(c)= O(|S|)  and S(c)=O(1)
	public static String removeConsecutiveCharacter(String S) {
		int n = S.length();
		String ans = "" + S.charAt(0);
		for (int i = 1; i < n; i++) {
			if (S.charAt(i) != S.charAt(i - 1))
				ans += S.charAt(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		String input = "aabaaaaaaaaaaaaaaaaaaaaac";
		String res = removeConsecutiveCharacter(input);
		System.out.println("After removing consective character The final String is::" + res);
	}

}
