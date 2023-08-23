package com.nt.string;

import java.util.Collections;
import java.util.HashMap;

public class St_53_IsogramStringCheck {

	
	//T(C)= O(N)  AND s(c)= O(N).
	public static boolean isIsogram(String data) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < data.length(); i++) {
			map.put(data.charAt(i), map.getOrDefault(data.charAt(i), 0) + 1);
		}
		int max = Collections.max(map.values());
		if (max == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
       String str="geeks";
       if(isIsogram(str))
    	   System.out.println("yes");
       else 
    	   System.out.println("No");
	}

}
