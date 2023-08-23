package com.nt.file;

import java.io.FileOutputStream;
import java.io.IOException;

public class File_03_FileOutputStream {

	public static void fileOutPut(String file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(65);
		String str="I am a professional Full Stack Java Developer";
		byte[]arr=str.getBytes();
		fos.write(arr);
		
		fos.close();
		System.out.println("Successfull inserted data.......");

	}

	public static void main(String[] args) throws IOException {
		String txt = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";

		fileOutPut(txt);
	}

}
