package com.nt.string;

public class St_58_SumOfNumberString {

	//T(C)= O(N)  and S(C)= O(N)
	public static long findSum(String str) {
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			int an = str.charAt(i) - '0';
			if (an >= 0 && an < 10)
				temp = temp * 10 + an;
			else {
				sum = sum + temp;
				temp = 0;
			}
		}
		sum = sum + temp;
		return sum;
	}

	public static void main(String[] args) {
     String str="1abc235GCDD";
     long res=findSum(str);
     System.out.println(res);
	}

}
