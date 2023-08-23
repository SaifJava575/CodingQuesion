package com.nt.imp;

import java.util.StringJoiner;

public class Imp_01_StringJoinerClass {

	public void message() {
		String name = "saifuddin";
		StringJoiner sj = new StringJoiner(".");
		sj.add(".pdf");
		System.out.println(name + ".pdf");

		String s1 = "saifuddin.pdf";
		String res = "";
		String add = "compress";
		for (int i = 0; i < s1.length(); i++) {
			res += s1.charAt(i);
			if (s1.charAt(i) == '.') {
				res += add;
				break;
			}
		}
		System.out.println(res);
	}

	public void substring() {
		String input = "saifuddin.pdf";
		String out = input.substring(0, 9);
		System.out.println(out + "Compress.pdf");
		int n = input.length() - 1;
		String output = "";
		String key = "";
		int count = 0;
		for (int i = input.length() - 1; i >= 0; i--) {
			key = input.charAt(i) + key;
			count++;
			if (input.charAt(i) == '.') {
				output = input.substring(0, n - count);
				System.out.println(output + "Compress.pdf");
			}
		}
	}

	public static void main(String[] args) {
        
        String s1="[{Saifuddin.pdf}]";
        System.out.println(s1);
        int n=s1.length();
        System.out.println(s1.substring(2, n-2));
        
        
	}

}
