package com.nt.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class St_07_PermutationString {
	static List<String> l;
 
	//T(C)=O(n! * n)  and S(C)=o(n)
	public static List<String> find_permutation(String s) {
		l = new ArrayList<>();
		permut(s, 0, s.length() - 1);
		Collections.sort(l);
		return l;
	}

	public static void permut(String s, int left, int right) {
		if (left == right) {
			if (!l.contains(s))
				l.add(s);

			return;
		}
		for (int i = left; i <= right; i++) {
			s = swap(s, i, left);
			permut(s, left + 1, right);
			s = swap(s, i, left);
		}

	}

	public static String swap(String s, int a, int b) {
		char arr[] = s.toCharArray();
		char c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		String str = "abcd";

		List<String> res = find_permutation(str);
		for (String ans : res) {
			System.out.print(ans + " ");
		}
	}

}
