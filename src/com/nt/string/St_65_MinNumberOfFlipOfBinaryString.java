package com.nt.string;

public class St_65_MinNumberOfFlipOfBinaryString {

	// T(C)=O(|S|). AND s(C)=O(1)
	public static int minFlips(String S) {
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < S.length(); i += 2) {
			if (S.charAt(i) != '0')
				cnt1++;
		}
		for (int i = 1; i < S.length(); i += 2) {
			if (S.charAt(i) != '1')
				cnt1++;
		}

		for (int i = 0; i < S.length(); i += 2) {
			if (S.charAt(i) != '1')
				cnt2++;
		}
		for (int i = 1; i < S.length(); i += 2) {
			if (S.charAt(i) != '0')
				cnt2++;
		}
		return Math.min(cnt1, cnt2);
	}

	public static void main(String[] args) {
		String str = "0001010111";
		int res = minFlips(str);
		System.out.println("Minimum Flips are required::" + res);
	}

}
