package com.nt.hard;

public class Hd_53_NextHappyNumber {

	// T(C)=O(N) AND s(c)=O(1)
	static int nextHappy(int N) {
		while (true)
			if (check(++N))
				return N;
	}

	static boolean check(int n) {
		if (n == 1 || n == 7)
			return true;
		if (n / 10 == 0)
			return false; // Both of the lines works alike (next line)
		// if(n==2 || n==3 || n==4 || n==5 || n==6 || n==8 || n==9) return false;
		int sum = 0;
		while (n > 0) {
			sum += Math.pow(n % 10, 2);
			n /= 10;
		}
		return check(sum);
	}

	public static void main(String[] args) {
		int N = 8;
		int response = nextHappy(N);
		System.out.println("The next happy number is ::" + response);
	}

}
