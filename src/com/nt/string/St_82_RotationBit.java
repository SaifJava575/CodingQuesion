package com.nt.string;

import java.util.ArrayList;

public class St_82_RotationBit {

	// T(c)=O(1) and S(c)=O(1)
	public static ArrayList<Integer> rotate(int n, int d) {
		ArrayList<Integer> list = new ArrayList<>();
		int a, b;
		d = d % 16;
		a = (n << d | (n >> (16 - d))) & 0xFFFF;
		b = (n >> d | (n << (16 - d))) & 0xFFFF;
		list.add(a);
		list.add(b);

		return list;
	}

	public static void main(String[] args) {
		int n = 28, d = 2;
		ArrayList<Integer> res = rotate(n, d);
		System.out.println(res);

	}

}
