package com.nt.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Imp_08_EmailValidation {
	
	public static boolean emailValidation(String emailId) {
		boolean isValid = false;
		try {
		
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(emailId);
		if (matcher.matches()) {
			isValid = true;
		} else
			isValid = false;
		return isValid;
		 }catch(Exception e) {
				e.printStackTrace();
				return isValid;
			}
	}

	public static void main(String[] args) {
		String email="DSFSFogic464564skjakfdajor89203DSFASFSDG4920402424oft12hfg0@gmaifdsfsflgfhf.au";
		if(emailValidation(email))
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}

}
