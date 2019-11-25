package com.mvn.test;

import com.mvn.test.vo.PhotoBoardVO;

public class ReflectionTest {
	public static void main(String[] args) {
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbNum(1);
		System.out.println(pb);
		
		String className = "com.mvn.test.vo.PhotoBoardVO";
		
	}
}
