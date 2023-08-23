package com.nt.string;

public class St_64_PrintFirstletterOfWord {

	// T(C)=O(n) and S(C)=O(1)
	public static String firstAlphabet(String S) {
		char[] ch = S.toCharArray();
		int length = ch.length;
		String res = "";
		res += ch[0];
		for (int i = 0; i < length; i++) {
			if (ch[i] == ' ') {
				res += ch[i + 1];
			}
		}
		return res;
	}

	public static String firstAlphabet1(String S) {
		StringBuilder sb = new StringBuilder();
		sb.append(S.charAt(0));
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) == ' ' && i < S.length()) {
				i++;
				sb.append(S.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "Bad is good";
		String res = firstAlphabet1(str);
		System.out.println(res);

	}

}
