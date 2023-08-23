package com.nt.string;

public class St_72_AddMinCharacterPalindrome {

	// T(C)=O(n) and S(c)=O(1)
	public static int addMinChar(String str) {
		int len = str.length();
		int start = 0, end = len - 1;
		int res = 0;
		while (start < end) {
			if (str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			} else {
				res++;
				start = 0;
				end = len - res - 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "ABCD";
		int res = addMinChar(str);
		System.out.println("Add min character is" + res);
	}

}
