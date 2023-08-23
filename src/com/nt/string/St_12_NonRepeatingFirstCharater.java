package com.nt.string;

import java.util.HashMap;

public class St_12_NonRepeatingFirstCharater {

	//T(C)=O(N) AND s(c)=O(n)
	public static String nonRepeatingCharater(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(map.get(ch)==1)
				return String.valueOf(ch);
		}
		return "$ OOPS!!!Non Repeating charter is not there!!!";
	}

	public static void main(String[] args) {
		String str = "simsim";
		String res=nonRepeatingCharater(str);
		System.out.println("First Non repeating charater is::"+res);

	}

}
