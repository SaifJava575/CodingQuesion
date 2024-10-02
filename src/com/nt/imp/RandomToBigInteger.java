package com.nt.imp;
import java.math.BigInteger;
import java.util.Random;

public class RandomToBigInteger {
    public static void main(String[] args) {
        // Generate a random number between 100000 and 999999
        int randomNumber = (new Random()).nextInt(900000) + 100000;

        // Convert the random number to a BigInteger
        BigInteger bigIntegerValue = new BigInteger(String.valueOf(randomNumber));

        // Print the result
        System.out.println("Random BigInteger: " + bigIntegerValue);
    }
}
