package com.nt.ninja;
public class NJ_11_WildcardMatching {

    public static boolean isMatch(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        
        // dp[i][j] will be true if str[0..i-1] matches pat[0..j-1]
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        // Empty string and empty pattern match
        dp[0][0] = true;
        
        // Deal with patterns with *
        for (int j = 1; j <= m; j++) {
            if (pat.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char strChar = str.charAt(i - 1);
                char patChar = pat.charAt(j - 1);
                
                if (patChar == '?' || patChar == strChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (patChar == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // Match 0 or more characters
                }
            }
        }
        
        return dp[n][m];
    }

    public static void main(String[] args) {
        // Sample Input 1
        String[] strs1 = {"aa", "aa", "cb", "adceb"};
        String[] pats1 = {"a", "*", "?a", "*a*b"};
        for (int i = 0; i < strs1.length; i++) {
            System.out.println(isMatch(strs1[i], pats1[i]));
        }

        // Sample Input 2
        String[] strs2 = {"abcd", "dddd", "asaa", "aaa"};
        String[] pats2 = {"ab*", "asc?", "*", "???"};
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(isMatch(strs2[i], pats2[i]));
        }
    }
}
