package com.nt.advanceddsa;

import java.util.ArrayList;

public class Ad_14_WordBreakTrie {

	// T(C)=O(n*l+|A|2) and S(C)=O(|A| + k)
	public static int wordBreak(String A, ArrayList<String> B) {
		if (B.contains(A))
			return 1;
		int n = A.length();
		for (int i = 1; i <= n; i++) {
			if (B.contains(A.substring(0, i)) && wordBreak(A.substring(i), B) == 1)
				return 1;
		}
		return 0;
	}

	public static void main(String[] args) {

		String B[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go",
				"mango" };
		String A = "ilike";
		ArrayList<String> arr = new ArrayList<>();
		for (String str : B)
			arr.add(str);
		int response = wordBreak(A, arr);
		System.out.println(response);

	}

}
