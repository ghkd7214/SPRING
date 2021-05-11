package kr.co.ch02.sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2021/04/12
 * 이름 : 이지황
 * 내용 : DI 어노테이션을 이용한 Ioc구현
 */

public class IocTest2 {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		Tv ltv = (Tv) ctx.getBean("lgTv");
		Tv stv = (Tv) ctx.getBean("samsungTv");
		
		ltv.power();
		ltv.chUp();
		ltv.soundUp();
		
		stv.power();
		stv.chUp();
		stv.soundUp();
	}

}
