package com.nt.string;

public class St_03_ReverseWordString {

	//T(c)=O(S)  and S(C)=O(S)
	public static String reverseWord(String s) {
		String[] str = s.split(" ");
		String res = "";
		for (int i = str.length - 1; i >= 0; i--) {
			res += str[i] + " ";
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "I love my country";
		String ans = reverseWord(str);
		System.out.println("Reverse word String is::" + ans);
	}

}
