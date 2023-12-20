package com.nt.imp;
public class Imp_10_EmailMasking {

    public static String maskEmail(String email) {
        if (email == null) {
            return "";
        }
        StringBuilder maskedEmail = new StringBuilder();
        if (email.contains("@")) {
            int atIndex = email.indexOf('@');
            if (atIndex - 2 <= 5) {
                maskedEmail.append(email, 0, atIndex - 1);
                maskedEmail.append(repeat('*', atIndex - 2));
            } else {
                maskedEmail.append(email, 0, atIndex - 3);
                maskedEmail.append(repeat('*', atIndex - 5));
            }
            maskedEmail.append(email, atIndex - 1, email.length());
        } else {
            maskedEmail.append(email);
        }
        return maskedEmail.toString();
    }

    private static String repeat(char c, int count) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeated.append(c);
        }
        return repeated.toString();
    }

    public static void main(String[] args) {
        String originalEmail = "logicsoft120@example.com";
        String maskedEmail = maskEmail(originalEmail);
        System.out.println("Original Email: " + originalEmail);
        System.out.println("Masked Email: " + maskedEmail);
    }
}
