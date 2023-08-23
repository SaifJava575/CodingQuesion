package com.nt.string;

import java.util.Stack;

public class St_02_ParenthesisCheck {

	//T(C)=O(n) and S(c)=O(n)
	public static boolean checkParenthesis(String x) {
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < x.length(); i++) {
			if (stack.isEmpty())
				stack.push(x.charAt(i));
			else if ((stack.peek() == '(' && x.charAt(i) == ')') || (stack.peek() == '{' && x.charAt(i) == '}')
					|| (stack.peek() == '[' && x.charAt(i) == ']'))
				stack.pop();
			else
				stack.push(x.charAt(i));
		}
		if (stack.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		String str = "";
		if(str.isEmpty())
			System.out.println("String can not be empty");
		else if (checkParenthesis(str))
			System.out.println("Balanced parenthesis");
		else
			System.out.println("Not balaneced parenthesis");

	}

}
