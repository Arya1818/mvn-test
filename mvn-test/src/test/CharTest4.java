package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharTest4 {
	public static void main(String[] args) {
		String path = "c:\\test.txt";
		try {
			FileInputStream fis = new FileInputStream(path); 			//파일에서 글자를가져옴
			InputStreamReader isr = new InputStreamReader(fis,"utf-8"); //utf-8로감싸줌
			BufferedReader br = new BufferedReader(isr); 				//라인으로읽고싶어
			String str = null;
			while ((str = br.readLine()) != null) { 					// 라인별로읽음
				System.out.println(str); 
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}


// 한 라인이 몇글자로 이루어져있는지 모른다. 그래서 원래는 한글자한글자 쪼개서 분석해야하는데 그런 역할을 BufferedReader가 해줌
// 콘솔에 출력되는값 - 우리가 input을 한 것
// I/O중요