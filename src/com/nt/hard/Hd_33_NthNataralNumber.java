package com.nt.hard;

public class Hd_33_NthNataralNumber {

	// T(C)=O(logN) and S(c)=O(1)
	static long findNth(long N) {
		long count = 0;
		long P = 1;
		while (N > 0) {
			count += (P * (N % 9));
			N = N / 9;
			P = P * 10;
		}
		return count;
	}

	public static void main(String[] args) {
		long response = findNth(9);
		System.out.println("Nth Nataral number is " + response);
	}

}
