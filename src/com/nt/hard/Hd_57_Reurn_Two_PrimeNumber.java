package com.nt.hard;

import java.util.ArrayList;
import java.util.List;

public class Hd_57_Reurn_Two_PrimeNumber {

	static List<Integer> primeDivision(int N) {
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 2; i < N; i++) {
			if (isPrime(i) && isPrime(N - i)) {
				res.add(i);
				res.add(N - i);
				break;
			}
		}
		return res;
	}


	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		List<Integer> response=primeDivision(74);
		System.out.println("Prime Devision Number is ::"+response);

	}

}
