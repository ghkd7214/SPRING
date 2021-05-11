package kr.co.ch03;

import org.springframework.stereotype.Component;

@Component
public class LogAdvice {

	public void beforeLog() {
		System.out.println("=====================");
		System.out.println("부가기능 - beforeLog");
	}

	public void afterLog() {
		System.out.println("부가기능 - afterLog");
		System.out.println("---------------------");
	}

	public void updateBefore() {
		System.out.println("=====================");
		System.out.println("부가기능 - updateBefore");
	}

	public void updateAfter() {
		System.out.println("부가기능 - updateAfter");
		System.out.println("---------------------");
	}

	public void deleteBefore() {
		System.out.println("=====================");
		System.out.println("부가기능 - deleteBefore");
	}

	public void deleteAfter() {
		System.out.println("부가기능 - deleteAfter");
		System.out.println("---------------------");
	}


}