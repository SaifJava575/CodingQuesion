package com.nt.string;

import java.util.Stack;

public class St_78_RestrictiveCandyCrush {

	// T(C)=O(|s|) and S(c)=O(|s|)
	public static String reduced_String(int k, String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int count = 0;
			stack.push(ch);
			while (stack.size() > 0 && stack.peek() == ch) {
				count++;
				stack.pop();
			}
			if (count == k)
				continue;

			while (count > 0) {
				stack.push(ch);
				count--;
			}
		}
		StringBuilder result = new StringBuilder();
		for (char ch : stack) {
			result.append(ch);
		}
		s = result.toString();
		return s;
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int k = 2;
		String res = reduced_String(k, str);
		System.out.println("The final Output is::" + res);
	}

}
