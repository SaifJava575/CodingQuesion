package com.nt.string;

public class St_52_RemoveSpace {

	
	//T(c)=O(|S|).  AND s(c)=O(1)
	public static String removeSpace(String str) {
		String res = str.replace(" ", "");
		return res;
	}

	public static String modify(String S) {
		String s = "";
		int n = S.length();
		for (int i = 0; i < n; i++) {
			if (S.charAt(i) != ' ') {
				s += S.charAt(i);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		String str = "S u j   a   n";
		String res = modify(str);
		System.out.println(res);
	}

}
