package com.iu.s1.start;

public class StartMain {

	public static void main(String[] args) throws Exception {
		System.out.println("DB 연동 테스트 시작");
		
		FrontController fc = new FrontController();
		fc.mainStart();
		
		System.out.println("DB 연동 테스트 끝");
	}

}
