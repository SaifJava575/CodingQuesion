package com.nt.string;

public class St_24_SumOfTwoLargerNumber {

	// T(C)=O(|X| + |Y|) and S(c)= O(1)
	public static String addTwoString(String X, String Y) {
		java.math.BigInteger x = new java.math.BigInteger(X);
		java.math.BigInteger y = new java.math.BigInteger(Y);
		java.math.BigInteger z = x.add(y);
		return String.valueOf(z);
	}

	public static void main(String[] args) {
		String s1 = "23", s2 = "12";
		String res = addTwoString(s1, s2);
		System.out.println("Summation of two string is::" + res);
	}

}
