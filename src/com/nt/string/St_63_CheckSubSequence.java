package com.nt.string;

public class St_63_CheckSubSequence {

	// T(c)=O(N) and S(C)=O(1)
	public static boolean isSubSequence(String A, String B) {
		int i = 0, j = 0;
		while (i < A.length() && j < B.length()) {
			if (A.charAt(i) == B.charAt(j)) {
				i++;
			}
			j++;
		}
		if (i == A.length())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String A = "AXY", B = "YADXCP";
		if (isSubSequence(A, B))
			System.out.println("yes");
		else
			System.out.println("No");

	}

}
