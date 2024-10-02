package com.nt.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Imp_07_MobileValidation {
	
	public static boolean mobileValidation(String mobileNo) {
		Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		Matcher m = p.matcher(mobileNo);
		      return (m.find() && m.group().equals(mobileNo));
	}

	public static void main(String[] args) {
		String mobileNo="9002063118";
		if(mobileValidation(mobileNo))
			System.out.println("Valid");
		else 
			System.out.println("Invalid");

	}

}
