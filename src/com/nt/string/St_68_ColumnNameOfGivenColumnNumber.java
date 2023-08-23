package com.nt.string;

public class St_68_ColumnNameOfGivenColumnNumber {

	// T(C)=O(LogN). and S(C)=O(1)
	public static String colName(long n) {
		StringBuffer ans = new StringBuffer();
		while (n > 0) {
			n--;
			ans.append((char) ((n % 26) + 'A'));
			n /= 26;
		}
		return ans.reverse().toString();

	}

	public static void main(String[] args) {
		String res = colName(44);
		System.out.println("The Given Column Name is::" + res);
	}

}
