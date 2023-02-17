package com.tek.java.day10;

import java.io.File;

public class MyMain {

	public static void main(String[] args) {
		String path = "C:/Users/jvit1/Downloads/testingfile.txt";
		
		File f = new File(path);
		System.out.println("File Name: " + f.getName());
		System.out.println("File Path: " + f.getPath());
		System.out.println("Is path absolute: " + f.isAbsolute());
		System.out.println("Return absolute path of the file: " + f.getAbsolutePath());
		System.out.println("Return parent folder of the given file: " + f.getParent());
		System.out.println("file is Exist: " + f.exists());
		System.out.println(f.exists() ? "Yes file exists" : "file does not exist");
		if(f.exists()) {
		System.out.println("File is found");
		System.out.println("Is file Readable " + f.canRead());
		System.out.println("Is file Writeable " + f.canWrite());
		System.out.println("file size in bytes " + f.length());
		}
		
	}
}
