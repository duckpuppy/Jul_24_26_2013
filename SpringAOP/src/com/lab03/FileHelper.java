package com.lab03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHelper {
	public static void write(String fileName,String contents){
		try {
			FileWriter fw = new FileWriter(fileName,true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(contents);
			pw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error writing to log " + e.getMessage());
		}
	}
}
