package kr.co.ch02.sub1;

public class LgTv implements Tv{

	@Override
	public void power() {
		System.out.println("LgTv power...");
		
	}
	@Override
	public void chUp() {
		System.out.println("LgTv chup...");
	}
	@Override
	public void chDown() {
		System.out.println("LgTv chdown...");
	}
	
	
}
