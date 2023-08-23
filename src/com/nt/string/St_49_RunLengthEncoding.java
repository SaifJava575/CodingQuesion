package com.nt.string;

public class St_49_RunLengthEncoding {

	// O(N), N = length of given string and S(C)=O(1)
	public static String encode(String str) {
		int n = str.length();
		int i = 0;
		StringBuilder encodedString = new StringBuilder();
		while (i < n) {
			char curr = str.charAt(i);
			int count = 0;
			while (i < n && str.charAt(i) == curr) {
				count++;
				i++;
			}
			encodedString.append(curr);
			encodedString.append(count);
		}
		return encodedString.toString();
	}

	public static void main(String[] args) {
		String str = "aaaabbbccc";
		String res = encode(str);
		System.out.println("The final output is ::" + res);

	}

}
