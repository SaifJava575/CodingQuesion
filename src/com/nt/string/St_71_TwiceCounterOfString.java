package com.nt.string;

import java.util.HashMap;
import java.util.Map;

public class St_71_TwiceCounterOfString {
	
	public static int countWords(String list[], int n) {
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		for (String s : list) {
			m.put(s, m.getOrDefault(s, 0) + 1);
		}
		int count = 0;
		for (Map.Entry<String, Integer> e : m.entrySet()) {
			if (e.getValue() == 2) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String str[] = { "saif", "logic", "logic", "sujan" };
		int res = countWords(str, str.length);
		System.out.println("Exactly Two Word are appear:" + res);
	}

}
