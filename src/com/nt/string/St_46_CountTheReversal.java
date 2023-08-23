package com.nt.string;

import java.util.Stack;

public class St_46_CountTheReversal {

	public static int countRev(String s) {
		if (s.length() % 2 != 0)
			return -1;

		int count = 0;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{')
				st.push(s.charAt(i));
			else if (s.charAt(i) == '}' && st.size() == 0) {
				count++;
				st.push('{');
			} else if (!st.isEmpty() && s.charAt(i) == '}')
				st.pop();

		}
		return count += st.size() / 2;
	}

	public static void main(String[] args) {
		String bracket = "}{}{}{{{";
		int res = countRev(bracket);
		System.out.println("Count the reversal bracket required is:" + res);
	}

}
