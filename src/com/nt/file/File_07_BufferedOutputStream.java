package com.nt.file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_07_BufferedOutputStream {

	public static void bufferOutputStream(String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String text = "Hellow Saifuddin how are you";
		byte[] arr = text.getBytes();
		bos.write(arr);
		bos.flush();
		bos.close();
		fos.close();
		System.out.println("Success write the data...........");
	}

	public static void main(String[] args) throws IOException {
		String txt = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		bufferOutputStream(txt);

	}

}
