package com.nt.string;

public class St_04_ReverseString {

	// T(C)=O(s) and S(C)=O(1)
	public static String reverseString(String s) {
		char[] ch = s.toCharArray();
		int left = 0, right = ch.length - 1;

		while (left < right) {
			char temp = ch[left];
			ch[left] = ch[right];
			ch[right] = temp;
			left++;
			right--;
		}
		return String.valueOf(ch);
	}

	public static void main(String[] args) {
		String str = "saifuddin";
		String res = reverseString(str);
		System.out.println("Reverse String is ::" + res);

	}

}
