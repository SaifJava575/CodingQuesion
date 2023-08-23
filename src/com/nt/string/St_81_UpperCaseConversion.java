package com.nt.string;

public class St_81_UpperCaseConversion {

	// T(C)=o(N) and S(C)=O(n)
	public static String transform(String s) {
		char[] ch = s.toCharArray();
		ch[0] = Character.toUpperCase(ch[0]);
		for (int i = 0; i < ch.length-1; i++) {
			if (ch[i] == ' ')
				ch[i + 1] = Character.toUpperCase(ch[i + 1]);
		}
		return new String(ch);
	}

	public static void main(String[] args) {
		String res = "I am sk saifuddin westBengal";
		String ans = transform(res);
		System.out.println("Transform String is::" + ans);
	}

}
