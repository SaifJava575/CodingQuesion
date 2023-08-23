package com.nt.string;

public class St_61_LargestWithGivenSum {

	// T(c)=O(N) and S(C)=O(1)
	public static String largestNumber(int n, int sum) {
		if (9 * n < sum)
			return "-1";
		String ans = "";
		for (int i = 0; i < n; i++) {
			if (sum >= 9) {
				ans += "9";
				sum -= 9;
			} else {
				ans += Integer.toString(sum);
				sum = 0;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 5, s = 15;
		String res = largestNumber(n, s);
		System.out.println(res);
	}

}
