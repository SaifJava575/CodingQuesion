package com.nt.string;

public class St_45_DisplayLongestName {
	 
	public static String longestName(String[] arr) {
		String name="";
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].length()>max) {
				max=arr[i].length();
				name=" ";
				name=arr[i];
			}
		}
		return name;
	}

	public static void main(String[] args) {
		String names[] = { "Geek", "Geeks", "Geeksfor", "GeeksforGeek", "GeeksforGeeks" };
		String res=longestName(names);
        System.out.println(res);
	}

}
