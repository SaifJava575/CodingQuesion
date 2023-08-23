package com.nt.string;

public class St_76_CompressValidString {

	public static int checkCompressed(String S, String T) {
		int n = 0;
		int j = 0;
		for (int i = 0; i < T.length(); i++) {
			char ch = T.charAt(i);
			if (ch >= '0' && ch <= '9') {
				n = n * 10 + ch - '0';
				j--;
			} else {
				j = j + n;
				if (ch != S.charAt(j))
					return 0;
				n = 0;
			}
			j++;
		}
		j = j + n;
		if (j != S.length())
			return 0;
		return 1;
	}

	public static void main(String[] args) {
		String S = "GEEKSFORGEEKS", T = "G7G3S";
		int res = checkCompressed(S, T);
		System.out.println("Valid compressed string is::" + res);

	}

}
