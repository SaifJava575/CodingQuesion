package com.nt.hard;

public class Hd_70_FindLastDIigitOfTheString {

	// T(C)= O(|b|) and S(C)=O(N)
	static int getLastDigit(String a, String b) {
		if (b.length() == 1 && b.equals("0"))
			return 1;
		if (a.equals("1"))
			return 1;
		int exponent = (Modulo(4, b) == 0 ? 4 : Modulo(4, b));
		int result = (int) (Math.pow(a.charAt(a.length() - 1) - '0', exponent));
		return result % 10;
	}

	private static int Modulo(int a, String b) {
		int res = 0;
		for (int i = 0; i < b.length(); i++) {
			res = (res * 10 + b.charAt(i) - '0') % a;
		}
		return res;
	}

	public static void main(String[] args) {
		String a = "3", b = "10";

		int response = getLastDigit(a, b);
		System.out.println("The last Disigit of the last Character is ::" + response);

	}

}
