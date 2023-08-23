package com.nt.string;

import java.util.Arrays;

public class St_25_InterleavedStrings {

	static int mat[][];
  
	//T(C)=O(N * M)  and S(C)= O(N * M)
	public static boolean isInterLeave(String a, String b, String c) {
		int m = a.length();
		int n = b.length();
		int l = c.length();

		if (m + n < c.length())
			return false;
		mat = new int[m + 1][n + 1];
		for (int ar[] : mat)
			Arrays.fill(ar, -1);
		return solve(a, b, c, m, n, l) == 0 ? false : true;
	}

	static int solve(String a, String b, String c, int m, int n, int l) {
		if (l == 0)
			return 1;
		if (mat[m][n] != -1)
			return mat[m][n];
		int one = 0, two = 0;
		if (m > 0 && a.charAt(m - 1) == c.charAt(l - 1))
			one = solve(a, b, c, m - 1, n, l - 1);
		if (n > 0 && b.charAt(n - 1) == c.charAt(l - 1))
			two = solve(a, b, c, m, n - 1, l - 1);

		return mat[m][n] = (one | two);
	}

	public static void main(String[] args) {
		
       if(isInterLeave("xyz", "abc", "xyazbc"))
    	   System.out.println("String are inter leaved to each other");
       else 
    	   System.out.println("String are not interleaved to each other");
	}

}
