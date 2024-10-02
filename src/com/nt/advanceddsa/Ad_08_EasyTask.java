package com.nt.advanceddsa;

import java.util.ArrayList;

class query {
	String type;
	String a;
	String b;
	String c;

	public query(String type, String a, String b, String c) {
		this.type = type;
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class Ad_08_EasyTask {

	// T(C)=O(N+(Q*logN)) and S(c)=O(N)
	public static ArrayList<Character> easyTask(int n, String s, int q, query queries[]) {
		ArrayList<Character> charList = new ArrayList<>(s.length());
		for (char c : s.toCharArray())
			charList.add(c);

		ArrayList<Character> res = new ArrayList<>();

		int[] charCount;

		for (query q : queries) {

			if (q.type.equals("1"))
				charList.set(Integer.parseInt(q.a), q.b.charAt(0));
			else {
				charCount = new int[26];

				int start = Integer.parseInt(q.a);
				int end = Integer.parseInt(q.b);
				int k = Integer.parseInt(q.c);

				for (int i = start; i <= end; i++) {
					char c = charList.get(i);
					charCount[(int) c - 97]++;
				}

				int count = 0;
				char resultChar = 0;

				for (int i = 25; i >= 0; i--) {
					count += charCount[i];
					if (count >= k) {
						resultChar = (char) (i + 97);
						break;
					}
				}

				res.add(resultChar);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "abab";
		int n = s.length();
		query queries[] = { new query("1", "2", "d", null), new query("2", "1", "3", "1") };
		int q = queries.length;
		ArrayList<Character> response = easyTask(n, s, q, queries);
		System.out.println(response);
	}

}
