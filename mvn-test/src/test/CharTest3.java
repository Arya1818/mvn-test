package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharTest3 {
	public static void main(String[] args) {
		String path = "c:\\test.txt";
		try {
			FileInputStream fis = new FileInputStream(path); 
			int i = -1;
			while ((i = fis.read()) != -1) { 		
				System.out.println((char) i);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
