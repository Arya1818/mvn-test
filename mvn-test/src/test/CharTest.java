package test;

public class CharTest {
	public static void main(String[] args) {
		char c = '가';
		int i = 16;
		char b = 'a';
		System.out.println(Integer.toHexString(i)); //10 (10진수)
		System.out.println(Integer.toHexString(c)); //ac00 (16진수)
		System.out.println(Integer.toHexString(b)); //61 (아스키코드값) 0~127까지 ?머?
	}
}

