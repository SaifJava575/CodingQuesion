package com.nt.hard;

import java.util.HashSet;
import java.util.Stack;

public class Hd_67_RedundantParenthesis {

	//T(C)=O(N)  amd S(C)=O(n)
	public static String removeBrackets(String S) {
		Stack<Integer> s = new Stack<>();
		Stack<Integer> op = new Stack<>();
		HashSet<Integer> del = new HashSet<>();
		int n = S.length();
		char[] a = S.toCharArray();

		for (int i = 0; i < n; i++) {
			char c = a[i];
			if (Character.isLetter(c))
				continue;
			else if (c == ')') {
				boolean addSub = false;
				boolean mulDiv = false;
				if (a[s.peek()] == '(') {
					del.add(i);
					del.add(s.pop());
				} else {
					while (a[s.peek()] != '(') {
						char d = a[s.pop()];
						op.pop();
						if (d == '*' || d == '/')
							mulDiv = true;
						else
							addSub = true;
					}
					int ind = s.pop();
					if (op.isEmpty()) {
						del.add(i);
						del.add(ind);
						continue;
					}
					char d = a[op.peek()];
					if (d == '+' || ((d == '*' || d == '-') && !addSub)) {
						del.add(i);
						del.add(ind);
					}
				}

			} else if (c == '(')
				s.push(i);
			else {
				s.push(i);
				op.push(i);
			}
		}
		String ans = "";
		for (int k = 0; k < S.length(); k++)
			if (!del.contains(k))
				ans += a[k];
		return ans;
	}

	public static void main(String[] args) {
		String s = "(A*(B+C))";
		String response = removeBrackets(s);
		System.out.println("The Reudndant Parenthesis is ::" + response);
	}
}
