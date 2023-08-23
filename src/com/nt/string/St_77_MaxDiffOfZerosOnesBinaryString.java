package com.nt.string;

public class St_77_MaxDiffOfZerosOnesBinaryString {

	// T(c)=O(|S|) and S(c)=O(1)
	public static int maxSubstring(String S) {
		int count = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < S.length(); i++) {
			if (count < 0)
				count = 0;

			if (S.charAt(i) == '0')
				count++;
			else
				count--;

			max = Math.max(count, max);
		}
		return max;

	}

	public static void main(String[] args) {
		int res = maxSubstring("11000010001");
		System.out.println("Maximum SubString is ::" + res);
	}

}
