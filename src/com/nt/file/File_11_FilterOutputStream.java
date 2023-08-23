package com.nt.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class File_11_FilterOutputStream {

	public static void filterOutputStream(String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		FilterOutputStream filos = new FilterOutputStream(fos);
		String str = "Ramadan Mubarak";
		byte[] arr = str.getBytes();
		filos.write(arr);
		fos.close();
		filos.close();
	}
	
	public static void filterInputStream(String path) throws IOException {
		File data=new File(path);
		FileInputStream fis=new FileInputStream(data);
		FilterInputStream filter=new BufferedInputStream(fis);
		int i=0;
		while((i=filter.read())!=-1);{
			System.out.println((char)i);
		}
		fis.close();
		filter.close();
	}

	public static void main(String[] args) throws IOException {
		String txt = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		filterOutputStream(txt);
		filterInputStream(txt);

	}

}
