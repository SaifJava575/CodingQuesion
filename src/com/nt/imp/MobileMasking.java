package com.nt.imp;
public class MobileMasking {

    public static String maskMobile(String mobile) {
        if (mobile == null || mobile.length() < 10) {
            return "";
        }
        StringBuilder maskedMobile = new StringBuilder(mobile.substring(0, 2));  // Copy first 2 characters
        maskedMobile.append(maskDigits(mobile.substring(6, 9)));  // Masking part
        maskedMobile.append(mobile.substring(9)); // Copy the rest of the characters

        return maskedMobile.toString();
    }

    private static String maskDigits(String digits) {
        return digits.replaceAll("[0-9]", "X");
    }

    public static void main(String[] args) {
        // Example usage:
        String originalMobile = "9876543210";
        String maskedMobile = maskMobile(originalMobile);
        System.out.println("Original Mobile: " + originalMobile);
        System.out.println("Masked Mobile: " + maskedMobile);
    }
}
