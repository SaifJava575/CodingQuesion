package com.nt.hard;

import java.util.Vector;

public class Hd_25_NextSmallestPalindromeNumber {

	// T(C)=O(N) and S(C)=O(1)
	static Vector<Integer> generateNextPalindrome(int[] num, int n) {
		boolean change = true; // because the current number has to change
		for (int i = 0; i < n / 2; i++) {
			if (num[i] > num[n - i - 1]) {
				change = false; // because the current number will become larger
			} else if (num[i] < num[n - i - 1]) {
				change = true; // current number becomes smaller than the previous
			}
			num[n - i - 1] = num[i];
		}

		Vector<Integer> ans = new Vector<>();
		for (int i = 0; i < n; i++) {
			ans.add(num[i]);
		}
		
		// code to make the number larger than the previous
		int index = n / 2;
		boolean carry = change;
		while (carry && index < n) {
			if (ans.get(index) == 9) {
				ans.set(index, 0);
				ans.set(n - index - 1, ans.get(index));
			} else {
				int incremented = ans.get(index) + 1;
				ans.set(index, incremented);
				ans.set(n - index - 1, incremented);
				carry = false;
			}
			index++;
		}

		if (carry) {
			ans.set(0, 1);
			ans.add(1);
		}

		return ans;
	}

	public static void main(String[] args) {
		int Num[] = { 9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2 };
		Vector<Integer> response = generateNextPalindrome(Num, Num.length);
		System.out.println("The next Smallest Palindrome Number is :" + response);
	}

}
