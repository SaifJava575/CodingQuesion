package com.nt.file;

import java.io.File;

public class File_01_FileCreated {

	public static void fileCreate(String filename) {
		try {

			// create a new File
			File file = new File(filename);
			file.createNewFile();
			System.out.println(file);

			// get Cannonical file
			File file2=file.getCanonicalFile();
			System.out.println(file2);
			
			//get Cannoical path
			String path=file.getCanonicalPath();
			System.out.println(path);
			
			//get Absulate File path
			File abs=file.getAbsoluteFile();
			System.out.println(abs);
			
			//get Absulate File path
			String absPath=file.getAbsolutePath();
			System.out.println(absPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		fileCreate("JavaFile.txt");
	}
}
