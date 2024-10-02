package com.nt.ninja;
import java.util.ArrayList;

public class Nj_05_NonRepeatingCharacter {
    public static ArrayList<Integer> findNonRepeating(ArrayList<Integer> a) {
        // Step 1: XOR all the elements
        int xorResult = 0;
        for (int num : a) {
            xorResult ^= num;
        }

        // Step 2: Find a bit that is different between the two unique numbers
        int differingBit = xorResult & -xorResult; // Gets the rightmost set bit

        // Step 3: Separate numbers into two groups and XOR them
        int num1 = 0, num2 = 0;
        for (int num : a) {
            if ((num & differingBit) != 0) {
                num1 ^= num; // XOR of numbers where the differingBit is set
            } else {
                num2 ^= num; // XOR of numbers where the differingBit is not set
            }
        }

        // Step 4: Return the result
        ArrayList<Integer> result = new ArrayList<>();
        result.add(num1);
        result.add(num2);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(7);
        arr.add(3);
        arr.add(2);
        arr.add(7);
        arr.add(2);

        ArrayList<Integer> result = findNonRepeating(arr);
        System.out.println(result); // Output: [4, 3]
    }
}
