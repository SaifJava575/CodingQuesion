package com.nt.string;

public class St_01_IP_Check {

	//T(C)=O(n)  and S(C)=O(1)
	public static boolean checkIp(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.')
				count++;
			else if (!Character.isDigit(s.charAt(i)))
				return false;
		}
		if (count != 3)
			return false;
		String[] arr = s.split("\\.");
		if (arr.length != 4)
			return false;
		for (String ele : arr) {
			if (ele == null || ele.equals(""))
				return false;
			if (0 > Integer.valueOf(ele) || Integer.valueOf(ele) > 255)
				return false;
			if (ele.length() > 1 && ele.charAt(0) == '0')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String ip = "0.0.127.0";

		if (checkIp(ip)) {
			System.out.println("It is valid ip address");
		} else
			System.out.println("It is not valid address");

	}

}
