package com.nt.ninja;

public class NJ_25_SumOrProduct {
	
	 private static final int MOD = 1000000007;

	
	public static long sumOrProduct(int n, int q) {

		if (q == 1) {
            // Sum of integers from 1 to N
            return (long) n * (n + 1) / 2; // Using formula: n(n + 1)/2
        } else if (q == 2) {
            // Product of integers from 1 to N
            long product = 1;
            for (int i = 1; i <= n; i++) {
                product = (product * i) % MOD; // Taking modulo at each step
            }
            return product;
        }
        return 0; 
	}

	public static void main(String[] args) {
		int n =4;
		int q=2;
		long res=sumOrProduct(n, q);
		System.out.println("Sum or Product of the Number is :"+res);

	}

}
