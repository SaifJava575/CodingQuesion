package com.nt.ninja;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NJ_09_FirstNonRepatingCharacter {

	public static char firstNonRepeatingCharacter(String str) {

		Map<Character,Integer> map=new LinkedHashMap<>();
		char arr[]=str.toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				char ch=arr[i];
				return ch; 
			}else {
				map.put(arr[i], 1);
			}
		}
		char res='x';
		for(Map.Entry<Character,Integer> val:map.entrySet()) {
			res=val.getKey();
			break;
		}
		return res;
	}
	public static void main(String[] args) {
		String str="aDcadhc";
		char res=firstNonRepeatingCharacter(str);
		System.out.println(res);
	}
}