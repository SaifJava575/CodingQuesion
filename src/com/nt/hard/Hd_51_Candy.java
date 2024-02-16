package com.nt.hard;

import java.util.Arrays;

public class Hd_51_Candy {

	// T(c)=O(N) and S(C)=O(1)
	static int minCandy(int N, int ratings[]) {
		int[] candies = new int[N];
		Arrays.fill(candies, 1);

		for (int i = 1; i < N; i++) {
			if (ratings[i] > ratings[i - 1])
				candies[i] = candies[i - 1] + 1;
		}

		for (int i = N - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
		}

		int totalCandies = 0;
		for (int candy : candies)
			totalCandies += candy;

		return totalCandies;
	}

	public static void main(String[] args) {
		int N = 3;
		int ratings[] = { 1, 2, 2 };
		int response = minCandy(N, ratings);
		System.out.println("Minmum Candy can be Distribute::" + response);

	}

}
