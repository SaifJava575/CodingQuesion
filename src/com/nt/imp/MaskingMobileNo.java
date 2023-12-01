package com.nt.imp;

public class MaskingMobileNo {

	public static String musk(String mob) {
		String res = "";
		for (int i = 2; i < mob.length() - 2; i++) {
			char x = mob.charAt(i);
			x = 'X';
			res += x;
		}
		String first = mob.substring(0, 2);
		String last = mob.substring(mob.length() - 2, mob.length());
		String response = first + res + last;
		return response;
	}

	public static void main(String[] args) {
		String mobileNo = "9002063118";
		String response = musk(mobileNo);
		System.out.println(response);

	}

}
