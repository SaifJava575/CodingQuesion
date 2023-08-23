package com.nt.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class File_08_BufferedInputStream {

	public static void bufferedInputStream(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);

		BufferedInputStream bis = new BufferedInputStream(fis);
		int i = 0;
		while ((i = bis.read()) != -1) {
			System.out.print((char) i);
		}
		bis.close();
		fis.close();

	}

	public static void main(String[] args) throws IOException {
		String txt = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		bufferedInputStream(txt);
	}

}
