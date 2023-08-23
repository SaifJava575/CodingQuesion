package com.nt.string;

public class St_48_AnagamOfString {

	public static int remAnagrams(String s, String s1) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int k = s.charAt(i) - 'a';
			arr1[k]++;
		}
		for (int i = 0; i < s1.length(); i++) {
			int k = s1.charAt(i) - 'a';
			arr2[k]++;
		}
		int ans = 0;
		for (int i = 0; i < 26; i++) {
			ans += (Math.abs(arr1[i] - arr2[i]));
		}
		return ans;
	}

	public static void main(String[] args) {
		String S1 = "bcdeha", S2 = "eah";
		int res = remAnagrams(S1, S2);
		System.out.println("Remove the character count is:" + res);

	}

}
