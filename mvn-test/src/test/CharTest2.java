package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CharTest2 {
	public static void main(String[] args) {
		String path = "c:\\test.txt";
		try {
			FileInputStream fis = new FileInputStream(path); //파일에서 글자를 가져옴. 바이트기반, 1바잍씩 읽음
			int s = fis.read();  //마지막에 없을때 -1을 끄집어냄 그래서 while문으로 -1이 아닐때까지돌림
			System.out.println((char)s); //ï -알수없는글자가나옴
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
