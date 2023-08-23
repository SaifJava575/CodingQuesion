package com.nt.string;

import java.util.Stack;

public class St_69_ReverseEachWordOfWString {

	//T(C)=O(|S|).  and S(c)=O(|S|).
	public static String reverseWords(String S) {
		Stack<Character> st = new Stack<>();
		String ans = "";
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) != '.') {
				st.push(S.charAt(i));
			} else {
				while (st.size() > 0)
					ans += st.pop();
				ans += '.';
			}
		}
		while (st.size() > 0) {
			ans += st.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "I.like.food";
		String res = reverseWords(str);
		System.out.println(res);
	}

}
