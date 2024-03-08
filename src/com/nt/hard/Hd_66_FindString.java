package com.nt.hard;

import java.util.HashSet;

public class Hd_66_FindString {

	public static String findString(int n, int k) {
		HashSet<String> hm = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(0);
		hm.add(sb.toString());
		generate(sb, 1, hm, k - 1);
		return sb.toString();
	}

	public static void generate(StringBuilder sb, int i, HashSet<String> hm, int k) {
		int b = k;
		String s1 = sb.substring(i);
		while (b >= 0) {
			String s2 = s1 + b;
			if (!hm.contains(s2)) {
				hm.add(s2);
				sb.append(b);
				generate(sb, i + 1, hm, k);
				break;
			}
			b--;
		}
	}

	public static void main(String[] args) {
		int N = 2, K = 3;
		String response = findString(N, K);
		System.out.println("Expected output is ::" + response);

	}

}
