package com.nt.string;

import java.util.HashMap;

public class St_16_RomanToInteger {

	
	//T(C)=O(|S|)  and S(C)=O(1)  S is the length of the String
	public static int romanToDecimal(String s) {
		int num = 0, sum = 0, prev = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'I':
				num = 1;
				break;
			case 'V':
				num = 5;
				break;
			case 'X':
				num = 10;
				break;
			case 'L':
				num = 50;
				break;
			case 'C':
				num = 100;
				break;
			case 'D':
				num = 500;
				break;
			case 'M':
				num = 1000;
				break;
			}
			if (prev > num)
				sum -= num;
			else
				sum += num;
			prev = num;
		}
		return sum;
	}
	
	 public static int romanToDecimal1(String str) {
	      HashMap<Character,Integer>map= new HashMap<>();
	      map.put('I',1);
	      map.put('V',5);
	      map.put('X',10);
	      map.put('L',50);
	      map.put('C',100);
	      map.put('D',500);
	      map.put('M',1000);
	      int sum=0;
	      int n=str.length();
	      for(int i=0;i<n;i++){
	         if(i<n-1 && map.get(str.charAt(i))<map.get(str.charAt(i+1))){
	             sum+=map.get(str.charAt(i+1))-map.get(str.charAt(i));
	             i++;
	         }
	         else{
	             sum+=map.get(str.charAt(i));
	         }
	      }
	      return sum;
	    }

	public static void main(String[] args) {
       String str="CMXCIX";
       int res=romanToDecimal1(str);
       System.out.println("The roman number is::"+res);
       
	}

}
