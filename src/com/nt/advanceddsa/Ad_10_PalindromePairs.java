package com.nt.advanceddsa;

public class Ad_10_PalindromePairs {

	//T(C)=O(N*l)^2   and S(C)=O(N*l)^2
	static boolean palindromepair(int N, String arr[]) {
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				if (arr[i].charAt(0) == arr[j].charAt(arr[j].length() - 1)
						|| arr[j].charAt(0) == arr[i].charAt(arr[i].length() - 1))
					if (palindrome(arr[i] + arr[j]) || palindrome(arr[j] + arr[i]))
						return true;

		return false;
	}

	public static boolean palindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {

		String arr[] = { "geekf", "geeks", "or", "keeg", "abc", "bc" };
		int n = arr.length;
		if (palindromepair(n, arr))
			System.out.println("1");
		else
			System.out.println("0");

	}

}
