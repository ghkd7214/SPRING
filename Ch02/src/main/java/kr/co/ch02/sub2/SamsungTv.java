package kr.co.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTv implements Tv{

	@Autowired
	private speaker speaker;
	
	
	@Override
	public void power() {
		System.out.println("SamsungTv power...");		
	}
	@Override
	public void chUp() {
		System.out.println("SamsungTv chUp...");		
	}
	@Override
	public void chDown() {
		System.out.println("SamsungTv chdown...");		
	}
	@Override
	public void soundUp() {
		speaker.soundUp();
	}
	@Override
	public void soundDown() {
		speaker.soundDown();
	}
}
