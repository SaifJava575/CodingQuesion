package com.nt.dp;

public class Dp_04_LongestPalindromeInString {
	
	public static String longestPalin(String s){
        char[] chars = s.toCharArray();
        String result = "";

        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length-1; j >=i; j--) {
                if (isPalindrome(chars, i,j)){
                    if (result.length()<j-i+1)
                        result = s.substring(i,j+1);                 
                    break;
                }
            }
        }
        return result;
    }
    private static boolean isPalindrome(char[] chars, int i, int j){
        for (;  i<=j ; i++,j--) {
            if (chars[i]!=chars[j])
                return false;
        }
        return true;
    }

	public static void main(String[] args) {
		String S = "aaaabbaa";
		String response=longestPalin(S);
		System.out.println("The longest Palindrome String is:"+response);

	}

}
