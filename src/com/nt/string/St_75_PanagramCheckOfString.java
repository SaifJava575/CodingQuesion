package com.nt.string;

import java.util.HashSet;

public class St_75_PanagramCheckOfString {

	// T(C)=O(N). and S(C)=O(N).
	public static boolean checkPangram(String str) {
		str = str.toLowerCase();
		HashSet<Character> hs = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				hs.add(str.charAt(i));
		}
		if (hs.size() == 26)
			return true;
		return false;
	}

	public static void main(String[] args) {
		String str = "Bawds jog, flick quartz, vex nymph";
		if (checkPangram(str))
			System.out.println("This sentence is panagram");
		else
			System.out.println("This sentence is not panagram");
	}

}
