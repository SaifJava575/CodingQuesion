package com.nt.string;

public class St_14_ImplementStrStr {

	// T(c)= O(|s|*|x|) and S(C)=O(1)
	public static int strstr(String s, String x) {
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == x.charAt(0)) && (s.length() - i >= x.length())) {
				int check_length = 0;
				int k = i, j = 0;
				while (j < x.length()) {
					if (s.charAt(k) == x.charAt(j)) {
						check_length++;
					}
					j++;
					k++;
				}
				if (x.length() == check_length) {
					return i;
				}
			}
		}
		return -1;
	}

	public static int strstr1(String s, String x) {
		if (s.contains(x))
			return s.indexOf(x);
		return -1;
	}

	public static void main(String[] args) {
		String str = "GeeksForGeeks", str2 = "For";

		int result = strstr1(str, str2);
		System.out.println("The implement string first index is::" + result);
	}

}
