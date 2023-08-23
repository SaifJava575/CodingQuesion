package com.nt.string;

import java.util.ArrayList;

public class St_15_FactorialOfLargeNumbers {

	
	//T(C)=O(N^2)  and S(C)=O(1)
	public static ArrayList<Integer> factorial(int N) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		for (int i = 1; i <= N; i++) {
			int carry = 0;
			for (int j = arr.size() - 1; j >= 0; j--) {
				int val = arr.get(j) * i + carry;
				arr.set(j, val % 10);
				carry = val / 10;
			}
			while (carry != 0) {
				arr.add(0, carry % 10);
				carry = carry / 10;
			}
		}
		return arr;
	}
	//T(C)=O(n)   and S(C)=O(n)
   public static int fact(int n) {
	   if(n==0|| n==1)
		   return 1;
	   else 
		   return n*fact(n-1);
   }

	public static void main(String[] args) {
		ArrayList<Integer> ans=factorial(5);
		for(Integer list:ans) {
			System.out.print(list+" ");
		}
		System.out.println();
		System.out.println("The factorial number is"+ans);
		
		
		int res=fact(5);		
		System.out.println("The factorial number is::"+res);

	}

}
