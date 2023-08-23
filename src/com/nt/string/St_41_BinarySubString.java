package com.nt.string;

public class St_41_BinarySubString {

	// T(C)=O(N) and S(C)=O(1)
	public static int binarySubstring(int a, String str) {
		int count = 0;
		int res = 0;
		for (int i = 0; i < a; i++) {
			if (str.charAt(i) == '1')
				count++;
		}
		res = count * (count - 1) / 2;
		return res;
	}

	public static void main(String[] args) {
		String input = "011111";
		int a = input.length();
		int res = binarySubstring(a, input);
		System.out.println("Number of binary SubString is::" + res);
	}

}
