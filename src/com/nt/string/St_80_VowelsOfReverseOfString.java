package com.nt.string;

public class St_80_VowelsOfReverseOfString {

	// T(C)=o(n/2) AND s(c)=o(s)
	public static String modify(String s) {
		int start = 0;
		int end = s.length() - 1;
		char ch[] = s.toCharArray();
		while (start < end) {
			if (!isVowel(ch[start])) {
				start++;
				continue;
			}
			if (!isVowel(ch[end])) {
				end--;
				continue;
			}
			char c = ch[start];
			ch[start] = ch[end];
			ch[end] = c;

			start++;
			end--;
		}
		return String.valueOf(ch);
	}

	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U')
			return true;

		return false;
	}

	public static void main(String[] args) {
		String input = "Saifuddin";
		String res = modify(input);
		System.out.println("Response string is:" + res);

	}

}
