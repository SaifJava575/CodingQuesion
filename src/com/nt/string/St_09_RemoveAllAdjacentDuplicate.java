package com.nt.string;

import java.util.Stack;

public class St_09_RemoveAllAdjacentDuplicate {
 
	//T(C)= O(|S|) and S(C)= O(|S|)
	public static String removeDuplicate(String s) {
		Stack<Character> st = new Stack<>();
		boolean Duplicate = false;
		for (int i = 0; i < s.length(); i++) {
			char Ch = s.charAt(i);
			if (st.size() == 0)
				st.push(Ch);
			else if (st.peek() == Ch) {
				Duplicate = true;
				continue;
			} else {
				if (Duplicate) {
					st.pop();
					Duplicate = false;
				}
				st.push(Ch);
			}

		}
		if (Duplicate) {
			st.pop();
			Duplicate = false;
		}
		StringBuilder ans = new StringBuilder();
		while (st.size() > 0)
			ans = ans.append(st.pop());

		if (ans.length() == s.length())
			return ans.reverse().toString();

		return (removeDuplicate(ans.reverse().toString()));
	}
	
	public static String removeDuplicate1(String s) {
		String s1 = "";
		while (s.length() != s1.length()) {
			s1 = s;
			s = remove2(s1);
		}
		return s;
	}

	private static String remove2(String s) {
		StringBuilder s2 = new StringBuilder();
		char[] s1 = s.toCharArray();
		int i = 0;
		int l = s1.length;
		while (i < l) {
			if (i < l - 1 && s1[i] == s1[i + 1]) {
				while (i < l - 1 && s1[i] == s1[i + 1])
					i++;
			} else {
				s2.append(s1[i]);
			}
			i++;
		}
		return s2.toString();
	}

	public static void main(String[] args) {

		String str = "saifuddin";
		String res = removeDuplicate1(str);
		System.out.println("Final String is ::" + res);
	}

}
