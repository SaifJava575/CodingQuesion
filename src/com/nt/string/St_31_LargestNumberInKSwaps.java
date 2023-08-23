package com.nt.string;

import java.util.Arrays;

public class St_31_LargestNumberInKSwaps {

	public static String largestNumber(String str) {
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		String s = String.valueOf(ch);
		String s1 = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			s1 += s.charAt(i);
		}
		return s1;
	}

	static String max;

	// O(n!/(n-k)!) , where n = length of input string and S(C)=O(n)
	public static String findMaximumNum(String str, int k) {
		max = str;
		findMaximum(str.toCharArray(), k);
		return max;
	}

	public static void findMaximum(char[] strArr, int k) {
		if (k == 0)
			return;

		for (int i = 0; i < strArr.length - 1; i++) {
			for (int j = i + 1; j < strArr.length; j++) {
				if (strArr[j] > strArr[i]) {
					strArr = swap(strArr, i, j);
					String st = new String(strArr);
					if (max.compareTo(st) < 0)
						max = st;
					findMaximum(strArr, k - 1);
					strArr = swap(strArr, i, j);
				}
			}
		}
	}

	public static char[] swap(char[] strArr, int i, int j) {
		char temp = strArr[i];
		strArr[i] = strArr[j];
		strArr[j] = temp;
		return strArr;
	}

	public static void main(String[] args) {
		String str = "9002063118";
		String res = largestNumber(str);
		System.out.println("Largest Number is::" + res);

		String input = "1234567";
		String output = findMaximumNum(input, 3);
		System.out.println("Maximum Large Number is::" + output);

	}

}
