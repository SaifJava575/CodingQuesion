package com.nt.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class File_15_OutputStreamWritterAndReader {

	public static void outputStreamWriter(String path) throws IOException {
		OutputStream out = new FileOutputStream(path);
		OutputStreamWriter osw = new OutputStreamWriter(out);
		osw.write("Ramadan Mubarak");
		osw.close();
	}

	public static void inputStreamReader(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis);
		int i = 0;
		while ((i = isr.read()) != -1)
			System.out.print((char) i);
		isr.close();

	}

	public static void main(String[] args) throws IOException {
		String path = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		outputStreamWriter(path);
		inputStreamReader(path);

	}

}
