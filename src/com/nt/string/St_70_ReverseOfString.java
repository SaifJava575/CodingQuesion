package com.nt.string;

public class St_70_ReverseOfString {

	public static String reverse(String str) {
		int i = 0, j = str.length() - 1;
		char ch[] = str.toCharArray();
		String res = "";
		while (i < j) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;			
		}
		return res;
	}
	
	public static String revStr(String S) {
        String abc = "";
        for(int i=S.length() -1; i>=0; i--){
            abc = abc + S.charAt(i);
        }
        return abc;
    }

	public static void main(String[] args) {
		String str = "saifuddin";
		String res = revStr(str);
		System.out.println(res);

	}

}
