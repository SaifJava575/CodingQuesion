package com.nt.file;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_05_ByteArrayOutputStream {

	public static void byteArrayOutputStream(String file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String str = "I am  sk saifuddin";
		byte[] arr = str.getBytes();
		baos.write(arr);
		baos.writeTo(fos);
		baos.flush();
		baos.close();
		System.out.println("Successfully insert the information............");
	}

	public static void main(String[] args) throws IOException {
		String txt = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		byteArrayOutputStream(txt);
	}

}
