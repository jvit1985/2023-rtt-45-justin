package com.tek.java.day10;

import java.io.File;
import java.io.IOException;

public class FileClassDemo {

	public static void main(String[] args) {
		   try {
		    File f = new File("C:/Users/jvit1/Downloads/Datafile.txt");
		     if (f.createNewFile()) {
		       System.out.println("New File created!");
		     } else {
		       System.out.println("The file already exists.");
		     }
		   } catch(IOException e) {
		     e.printStackTrace();
		   }
		 }
}
