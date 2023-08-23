package com.nt.test;

import java.util.ArrayList;
import java.util.List;

public class UsernameChnages {

	public static List<String> possibleChanges(List<String> usernames) {
		List<String> list = new ArrayList<>();
		Object data[] = usernames.toArray();
		for(int i=0;i<usernames.size();i++)
			list.add("NO");
		for (int j = 0; j < data.length; j++) {
			String str = (String) data[j];
			char[] chars = str.toCharArray();
			for (int i = 1; i < chars.length; i++) {
				if (chars[i - 1] > chars[i]) {
					char temp = chars[i-1];
					chars[i-1] = chars[i];
					chars[i] = temp;
					list.remove(j);
					list.add(j, "YES");
					break;
				}			
			}
			
		}
		return list;
	}

	public static String swapAlphabeticalOrder(String input) {
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] > chars[i + 1]) {
				char temp = chars[i];
				chars[i] = chars[i + 1];
				chars[i + 1] = temp;
			}
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		String input = "ALphabet";
		String output = swapAlphabeticalOrder(input);
		System.out.println(output);

		List<String> list = new ArrayList<>();
		list.add("bee");
		list.add("superhero");
		list.add("ace");

		List<String> response = possibleChanges(list);
		System.out.println("Possible Chnages are " + response);

	}

}
