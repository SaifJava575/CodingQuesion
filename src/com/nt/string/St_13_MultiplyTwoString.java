package com.nt.string;

import java.math.BigInteger;

public class St_13_MultiplyTwoString {

	//T(c)= O(n1* n2)  and S(C)=O(n1 + n2)
	public static String multiplyTwoString(String s1, String s2) {
		BigInteger big1 = new BigInteger(s1);
		BigInteger big2 = new BigInteger(s2);
		BigInteger mul = big1.multiply(big2);
		return String.valueOf(mul);
	}

	public static void main(String[] args) {
		String str = "33", str1 = "10";
		
		String res=multiplyTwoString(str, str1);
		System.out.println("The expected output is ::"+res);

	}

}
