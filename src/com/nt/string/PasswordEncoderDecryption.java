package com.nt.string;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class PasswordEncoderDecryption {

	public static void main(String[] args) {
		
		Encoder encoder=Base64.getEncoder();
		String org="saifuddin";
		String str=encoder.encodeToString(org.getBytes());
		System.out.println(str);
		
		Decoder decoder=Base64.getDecoder();
		byte[] dec=decoder.decode("JzmTT6nfBsMe/jBIUDL5rzOi9LGndy/JgJkhO+nyrOw=");
		System.out.println(new String(dec));
		

	}

}
