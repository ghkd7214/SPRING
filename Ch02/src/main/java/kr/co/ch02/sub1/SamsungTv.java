package kr.co.ch02.sub1;

public class SamsungTv implements Tv{

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
	
	
}
