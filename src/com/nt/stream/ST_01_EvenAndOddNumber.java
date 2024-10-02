package com.nt.stream;

import java.util.Arrays;
import java.util.List;

public class ST_01_EvenAndOddNumber {
	
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(2,3,4,5,6,7,8,9);
		list.stream().filter(n->n%2==0).forEach(System.out::print);
		System.out.println();
		list.stream().filter(n->n%2==1).forEach(System.out::print);

	}

}
