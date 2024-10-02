package com.nt.imp;
public class Imp_09_AadharMasking {

    public static String maskAadhar(String aadhar) {
        if (aadhar == null) 
            return null;
        StringBuilder maskedAadhar = new StringBuilder();
        if (aadhar.length() >= 10) {
            maskedAadhar.append(aadhar, 0, 3);  
            maskedAadhar.append("xxxxxx");      
            maskedAadhar.append(aadhar, 9, 12); 
        } else {
            maskedAadhar.append(aadhar);
        }

        return maskedAadhar.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        String originalAadhar = "454542123223";
        String maskedAadhar = maskAadhar(originalAadhar);
        System.out.println("Original Aadhar: " + originalAadhar);
        System.out.println("Masked Aadhar: " + maskedAadhar);
    }
}
