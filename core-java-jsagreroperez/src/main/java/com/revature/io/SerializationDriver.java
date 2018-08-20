package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationDriver {

	public static void main(String[] args) {
		Cereal c = new Cereal(true, 150, 20, "Lucky Charms");
		
		FileOutputStream fos;
		try {
			FileOutputStream fos = new FileOutputStream("./Cereal.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(c);
			oos.close();
			fos.close();
			System.out.println("we are don cerea-lizing");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
	}
}
