package com.nt.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class St_35_MaximumOccuringCharacter {

	// T(C)=O(N). AND S(C)=O(Number of distinct characters)
	public static char getMaxOccuringChar(String line) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < line.length(); i++) {
			map.put(line.charAt(i), map.getOrDefault(line.charAt(i), 0) + 1);
		}
		int max = Collections.max(map.values());
		ArrayList<Character> al = new ArrayList<Character>();
		for (char i : map.keySet()) {
			if (map.get(i) == max) {
				al.add(i);
			}
		}
		Collections.sort(al);
		return al.get(0);
	}

	public static void main(String[] args) {
		String str = "saifuddin";
		char res = getMaxOccuringChar(str);
		System.out.println("Maximum Occuring Character is::" + res);

	}

}
