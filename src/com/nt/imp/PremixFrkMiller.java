package com.nt.imp;

public class PremixFrkMiller {

	public static void main(String[] args) {
		String str="Rice Flour for preparation of Fortified Rice Kernel (FRK)[6.2.1]";
		String s1="Fortified Rice Kernel";
		if(str.contains(s1))
			System.out.println("Yes");
		else
		System.out.println("No");
	}

}
