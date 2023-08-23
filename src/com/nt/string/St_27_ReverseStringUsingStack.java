package com.nt.string;

import java.util.Stack;

public class St_27_ReverseStringUsingStack {

	public static String stackUsing(String str) {
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < str.length(); i++)
			st.push(str.charAt(i));
		
		StringBuilder temp = new StringBuilder();
		
		while (!st.isEmpty()) 
			temp.append(st.pop());
		
		return temp.toString();

	}

	public static void main(String[] args) {
		String str = "saifuddin";
		String res = stackUsing(str);
		System.out.println("Reverse of the String is::" + res);
	}

}
