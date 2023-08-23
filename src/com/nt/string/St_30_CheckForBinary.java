package com.nt.string;

public class St_30_CheckForBinary {

	public static boolean binaryCheck(String str) {
		int i = 0, r = str.length();
		while (i < r) {
			if (str.charAt(i) != '0' && str.charAt(i) != '1')
				return false;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "510001101";
		if (binaryCheck(str))
			System.out.println("This String is banary number");
		else
			System.out.println("This is not binary number............");
	}

}
