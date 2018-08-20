package com.revature.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
	public static void main(String[] args) {
		String path = "src/com/revature/io/data.txt";
		String content = "\nShellow b lah l\blah";
		//specify the file we want to write to
		File file = new File(path);
		try {
		//checking first to see if the file exists, creating it if it doesn't
		if(!file.exists()) {
			file.createNewFile();
			
		}
		FileWriter fw = new FileWriter(file, true);// second boolean parameter specifies if we are appending to a file
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(content);
		System.out.println("Our file has been written");
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}
