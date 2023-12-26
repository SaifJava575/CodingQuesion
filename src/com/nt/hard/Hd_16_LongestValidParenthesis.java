package com.nt.hard;

import java.util.Stack;

public class Hd_16_LongestValidParenthesis {

	//T(C)=O(n)  and S(C)=O(1)
	public static int maxLength(String str) {
		int b = 0, len = 0, res1 = 0, res2 = 0, i, n = str.length();
		for (i = 0; i < n; i++) {
			if (str.charAt(i) == ')')
				b--;
			else
				b++;
			len++;
			if (b < 0) {
				len = 0;
				b = 0;
			}
			if (b == 0)
				res1 = Math.max(res1, len);
		}
		len = 0;
		b = 0;
		for (i = n - 1; i >= 0; i--) {
			if (str.charAt(i) == ')')
				b++;
			else
				b--;
			len++;
			if (b < 0) {
				len = 0;
				b = 0;
			}
			if (b == 0)
				res2 = Math.max(res2, len);
		}
		return (Math.max(res1, res2));
	}

	//T(C)=O(n)  and S(C)=O(n)
	public static int maxLength1(String S) {
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);
		int mxl = 0;
		for (int k = 0; k < S.length(); k++) {
			char ccc = S.charAt(k);
			if (ccc == '(') {
				stk.push(k);
			} else if (ccc == ')') {
				stk.pop();
				if (!stk.isEmpty()) {
					mxl = Math.max(mxl, k - stk.peek());
				} else {
					stk.push(k);
				}
			}
		}
		return mxl;
	}

	public static void main(String[] args) {
		String parenthesis = "((())";
		int response = maxLength1(parenthesis);
		System.out.println("Longest Valid Parenthesis :" + response);

	}

}
