package com.nt.string;

public class St_22_StringRotationEachOther {

	//T(c)=O(N)   and S(C)=O(N)
	public static boolean areRotations(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		s1 = s1 + s1;
		int x = s1.indexOf(s2);
		if (x == -1)
			return false;
		return true;
	}

	public static void main(String[] args) {

		String s1 = "madam", s2 = "daamm";
		if(areRotations(s1, s2))
          System.out.println("String are ratation to each other");
		else 
			System.out.println("String are not rotate to each other");
	}

}
