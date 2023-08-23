package com.nt.string;

import java.math.BigInteger;

public class St_60_AddBinaryString {

	public static String addBinary(String A, String B) {
		BigInteger x = new BigInteger(A, 2);
		BigInteger y = new BigInteger(B, 2);
		y = x.add(y);

		return y.toString(2);
	}

	public static void main(String[] args) {
		String str = "1101", s1 = "111";
        String res=addBinary(str, s1);
        System.out.println(res);
        		
	}

}
