package kr.co.ch02.sub2;

import org.springframework.stereotype.Component;

@Component
public class speaker {

	public void soundUp() {
		System.out.println("Speaker soundUp...");
	}
	
	public void soundDown() {
		System.out.println("Speaker soundDown...");
	}
	
}
