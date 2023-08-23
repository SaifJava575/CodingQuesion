package com.nt.string;

import java.util.Stack;

public class St_28_LongestValidParenthesis {

	//T(C)=O(|S|)  and S(C)=O(|S|)
	public static int maxLength(String S) {
		int n = S.length();
		if (n == 1)
			return 0;
		int ans = Integer.MIN_VALUE;
		Stack<Integer> st = new Stack<>();
		st.push(-1);
		for (int i = 0; i < n; i++) {
			if (S.charAt(i) == '(') {
				st.push(i);
			} else {
				st.pop();
				if (st.isEmpty()) {
					st.push(i);
				} else
					ans = Math.max(ans, i - st.peek());
			}
		}
		if (ans == Integer.MIN_VALUE)
			return 0;
		return ans;
	}

	public static void main(String[] args) {
		String str = "(()()(";
		int res = maxLength(str);
		System.out.println("Valid Sub String length is::" + res);
	}

}
