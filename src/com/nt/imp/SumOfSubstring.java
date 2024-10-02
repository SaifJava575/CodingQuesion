package com.nt.imp;
import java.util.HashMap;
import java.util.Map;

public class SumOfSubstring {

    // Method to find the most frequent element in a string
    public static char findMostFrequentElement(String str) {
        // Create a frequency map to store the count of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // Iterate through the string and update the frequency map
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        // Find the most frequent character
        char mostFrequent = '\0';
        int maxFrequency = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequent = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return mostFrequent;
    }

    // Method to calculate sum of substrings containing the most frequent element
    public static int sumOfSubstring(String str) {
        char mostFrequent = findMostFrequentElement(str);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) == mostFrequent) {
                    // If the substring contains the most frequent element, add its integer value to sum
                    sum += Integer.parseInt(str.substring(i, j + 1));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "abcaacbb"; // Change this string as needed
        int sum = sumOfSubstring(str);
        System.out.println("Sum of substrings containing the most frequent element: " + sum);
    }
}
