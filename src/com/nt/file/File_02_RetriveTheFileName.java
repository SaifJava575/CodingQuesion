package com.nt.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class File_02_RetriveTheFileName {

	public static void readFile(String filename) throws FileNotFoundException {
		
		File file = new File(filename);
		
		//get the file name in the location
		String[] info = file.list();
		for (String data : info) {
			System.out.println(data);
		}
		
		//get the fileName and property
		File[] files=file.listFiles();
		for(File fileArr:files) {
			System.out.println(fileArr.getName()+" Can write: "+fileArr.canWrite()+" is Hidden: "+fileArr.isHidden()+" Length: "+fileArr.length());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		//String file = "D:\\SaifuddinWorkSpace\\CompressFile";
		String file = "D:/SaifuddinWorkSpace/CompressFile";	
		readFile(file);

	}

}
