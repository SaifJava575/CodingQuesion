package com.nt.sdesheet;

import java.util.Stack;

public class SD_16_ParenthesisChecker {

	// T(c)=O(n) and S(C)=O(1)
	static boolean ispar(String x) {
		Stack<Character> st = new Stack<>();
		for (char c : x.toCharArray()) {
			if (c == '(')
				st.push(')');
			else if (c == '{')
				st.push('}');
			else if (c == '[')
				st.push(']');
			else if (st.isEmpty() || st.pop() != c)
				return false;
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
		String x = "{([])}";
		if (ispar(x))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
